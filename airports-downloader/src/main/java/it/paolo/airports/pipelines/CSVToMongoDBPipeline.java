package it.paolo.airports.pipelines;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.opencsv.CSVReader;
import it.paolo.airports.mongo.pojos.MongoAirport;
import org.jsoup.helper.StringUtil;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Map;

/**
 * @author pvidari
 * @version 1.0
 * Process the csv file and persists the data to mongo
 */
public class CSVToMongoDBPipeline implements Pipeline {

    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';

    @Override
    public void process(ResultItems resultItems, Task task) {
        final String csvFileContent = resultItems.get("CSV_RESULT");
        if (StringUtil.isBlank(csvFileContent)) return;

        final MongoClient mongoClient = MongoClients.create();
        final MongoDatabase mongoDB = mongoClient.getDatabase("airports");
        int count = 0;
        try {
            final CSVReader reader = new CSVReader(new StringReader(csvFileContent), DEFAULT_SEPARATOR, DEFAULT_QUOTE);
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (count == 0) {
                    count++;
                    continue;
                }
                final MongoAirport mongoAirport = createMongoAirport(line);
                final Map<String, Object> airportMap = convertToMap(mongoAirport);
                if (InsertInMongo(mongoDB, airportMap)) {
                    System.out.println("INSERT DONE");
                } else {
                    System.out.println("PROBLEM WITH LINE ::: " + line);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * creates the mongo airport object from csv line
     *
     * @param line the csv line
     * @return mongo airport object with needed data
     */
    private MongoAirport createMongoAirport(String[] line) {
        final MongoAirport airport = new MongoAirport();
        airport.setAereoporto(line[0]);
        airport.setNomeCommerciale(line[1]);
        airport.setComune(line[2]);
        airport.setIndirizzo(line[3]);
        airport.setCodiceIATA(line[4]);
        airport.setCodiceICAO(line[5]);
        airport.setTipoUtilizzo(line[6]);
        airport.setInteresseNazionale(line[7]);
        airport.setTENTCORENetwork_COMPREHENSIVENetwork(line[8]);
        airport.setCertificato(line[9]);
        airport.setGestore(line[10]);
        airport.setScadenza(line[11]);
        airport.setN_Certificato(line[12]);
        airport.setDirezione_Ufficio_operazioni_ENAC(line[13]);
        airport.setNote_certificato(line[14]);
        airport.setSitoWeb(line[14]);
        final List<Double> coordinates = Lists.newLinkedList();
        coordinates.add(Double.parseDouble(line[17]));
        coordinates.add(Double.parseDouble(line[16]));
        airport.setCoordinates(coordinates);
        return airport;
    }

    /**
     * converts the object to a Map
     *
     * @param obj the object that needs to be converted
     * @return a Map representing the object
     */
    private Map<String, Object> convertToMap(Object obj) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            final String jsonAirport = mapper.writeValueAsString(obj);
            return mapper.readValue(jsonAirport, new TypeReference<Map<String, Object>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maps.newHashMap();
    }

    /**
     * insterts the map in mongo
     *
     * @param mongoDB    mongoDb instance
     * @param airportMap map that needs to be persists in mongo
     * @return true if insert ok, false instead
     */
    private boolean InsertInMongo(final MongoDatabase mongoDB, final Map<String, Object> airportMap) {
        try {
            final MongoCollection mongoCollection = mongoDB.getCollection("italian_airports");
            mongoCollection.insertOne(new Document(airportMap));
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

}
