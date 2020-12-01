package KW48.u2_1_v2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Eine Klasse zum Einlesen von Datensätzen im CSV-Format eines Tiersichtungsberichts.
 * 
 * @author David J. Barnes und Michael Kölling
 * @version 2016.02.29
 */
public class SichtungEinleser
{
    // Wie viele Felder erwartet werden 
    private static final int ANZAHL_FELDER = 5;
    // Indexwerte für die Felder in den Datensätzen
    private static final int MELDER = 0,
                             TIER = 1,
                             ANZAHL = 2,
                             GEBIET = 3,
                             ZEITRAUM = 4;
    
    /**
     * Erzeuge einen SichtungEinleser.
     */
    public SichtungEinleser()
    {
    }
    
    /**
     * Lies Sichtungen im CSV-Format aus der angegebenen Datei.
     * Gib eine ArrayList der Sichtung-Objekte zurück, die anhand
     * der Informationen in der Datei erzeugt wurde.
     * 
     * @param dateiname  die einzulesende Datei - sollte im CSV-Format sein
     * @return           eine Liste der Sichtungen
     */
    public ArrayList<Sichtung> gibSichtungen(String dateiname)
    {
        // Erzeuge eine Sichtung aus einer CSV-Eingabezeile.
        Function<String, Sichtung> erzeugeSichtung = 
            record -> {
                           String[] teile = record.split(",");
                           if(teile.length == ANZAHL_FELDER) {
                               try {
                                   int melder = Integer.parseInt(teile[MELDER].trim());
                                   String tier = teile[TIER].trim();
                                   int anzahl = Integer.parseInt(teile[ANZAHL].trim());
                                   int gebiet = Integer.parseInt(teile[GEBIET].trim());
                                   int zeitraum = Integer.parseInt(teile[ZEITRAUM].trim());
                                   return new Sichtung(tier, melder, anzahl, gebiet, zeitraum);
                               }
                               catch(NumberFormatException e) {
                                   System.out.println("Sichtungsdatensatz enthält Zahl im falschen Format: " + record);
                                   return null;
                               }
                           }
                           else {
                               System.out.println("Sichtungsdatensatz hat die falsche Anzahl an Feldern: " + record);
                               return null;
                           }
                       };
        ArrayList<Sichtung> sichtungen;
        try {
            sichtungen = Files.lines(Paths.get(dateiname))
                             .filter(datensatz -> datensatz.length() > 0 && datensatz.charAt(0) != '#')
                             .map(erzeugeSichtung)
                             .filter(sichtung -> sichtung != null)
                             .collect(Collectors.toCollection(ArrayList::new));
        }
        catch(IOException e) {
            System.out.println("Kann nicht geöffnet werden: " + dateiname);
            sichtungen = new ArrayList<>();
        }
        return sichtungen;
    }
    
}
