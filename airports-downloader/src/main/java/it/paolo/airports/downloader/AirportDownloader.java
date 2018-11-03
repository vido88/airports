package it.paolo.airports.downloader;

import it.paolo.airports.pipelines.CSVToMongoDBPipeline;
import it.paolo.airports.processors.AirportsProcessor;
import us.codecraft.webmagic.Spider;

/**
 * @author  pvidari
 * @version 1.0
 * project entry point
 */
public class AirportDownloader
{
    private final static String StartURL = "https://www.dati.gov.it/api/3/action/package_list";

    public static void main( String[] args )
    {
        Spider.create(new AirportsProcessor()).addUrl(StartURL)
                .addPipeline(new CSVToMongoDBPipeline())
                .thread(1).run();
    }
}
