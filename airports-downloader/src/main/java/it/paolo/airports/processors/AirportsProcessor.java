package it.paolo.airports.processors;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.paolo.airports.pojos.Airport;
import it.paolo.airports.pojos.PackageList;
import it.paolo.airports.pojos.Resource;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.IOException;
import java.util.List;

/**
 * @author pvidari
 * @version 1.0
 * process the download page to extract needed links or download csv file
 */
public class AirportsProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public Site getSite() {
        return site;
    }

    private final String packageShowBaseURL = "http://www.dati.gov.it/api/3/action/package_show?id=";
    private final String airportPackageName = "aeroporti-certificati";

    @Override
    public void process(Page page) {
        final ObjectMapper mapper = new ObjectMapper();
        if (!page.getUrl().toString().contains(airportPackageName) & !page.getUrl().toString().contains("csv")) {
            processDatiGov(page, mapper);
        } else if (!page.getUrl().toString().contains("csv")) {
            processAirportPackage(page, mapper);
        } else {
            page.putField("CSV_RESULT", page.getRawText());
        }
    }

    /**
     * process the json page to add url to airportPackage url
     * @param page the page that needs to be analyzed
     * @param mapper the mapper to serialize json page to the corresponding object
     */
    private void processDatiGov(final Page page, final ObjectMapper mapper) {
        try {
            final PackageList packageList = mapper.readValue(page.getRawText(), PackageList.class);
            List<String> results = packageList.getResult();
            final String airportEndpoint = results.stream().filter(airportPackageName::equals).findAny().get();
            final String showPackageUrl = String.format("%s%s", packageShowBaseURL, airportEndpoint);
            page.addTargetRequest(new Request(showPackageUrl));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * process json to extract csv url
     * @param page the paage that needs to be analyzed
     * @param mapper the mapper to serialize json page to the corrsponding object
     */
    private void processAirportPackage(final Page page, final ObjectMapper mapper) {
        try {
            final Airport airports = mapper.readValue(page.getRawText(), Airport.class);
            final List<Resource> resources = airports.getResult().getResources();
            for (Resource resource : resources) {
                if (resource.getMimetype().equals("csv")) {
                    final String csvUrl = resource.getUrl();
                    page.addTargetRequest(csvUrl);
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
