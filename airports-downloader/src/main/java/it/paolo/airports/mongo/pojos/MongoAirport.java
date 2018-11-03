package it.paolo.airports.mongo.pojos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class MongoAirport {

    @Getter
    @Setter
    String Aereoporto;
    @Getter
    @Setter
    String NomeCommerciale;
    @Getter
    @Setter
    String Comune;
    @Getter
    @Setter
    String Indirizzo;
    @Getter
    @Setter
    String CodiceIATA;
    @Getter
    @Setter
    String CodiceICAO;
    @Getter
    @Setter
    String TipoUtilizzo;
    @Getter
    @Setter
    String InteresseNazionale;
    @Getter
    @Setter
    String TENTCORENetwork_COMPREHENSIVENetwork;
    @Getter
    @Setter
    String Certificato;
    @Getter
    @Setter
    String Gestore;
    @Getter
    @Setter
    String N_Certificato;
    @Getter
    @Setter
    String Scadenza;
    @Getter
    @Setter
    String Direzione_Ufficio_operazioni_ENAC;
    @Getter
    @Setter
    String Note_certificato;
    @Getter
    @Setter
    String SitoWeb;
    @Getter
    @Setter
    List<Double> coordinates;
}
