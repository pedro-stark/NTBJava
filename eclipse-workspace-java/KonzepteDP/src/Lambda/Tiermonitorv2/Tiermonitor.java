package Lambda.Tiermonitorv2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

/**
 * Monitor-Auszählungen von verschiedenen Tierarten.
 * Sichtungen werden von Meldern aufgezeichnet.
 * 
 * @author David J. Barnes und Michael Kölling
 * @version 2016.03.01 (funktionale Version)
 */
public class Tiermonitor 
{
    // Datensätze aller Tiersichtungen.
    private ArrayList<Sichtung> sichtungen;

    /**
     * Erzeuge einen Tiermonitor.
     */
    public Tiermonitor()
    {
        this.sichtungen = new ArrayList<>();
    }

    /**
     * Füge zur aktuellen Liste die Sichtungen aus der angegebenen Datei hinzu.
     * @param dateiname  eine CSV-Datei mit den Sichtungsdatensätzen
     */
    public void sichtungenHinzufuegen(String dateiname)
    {
        SichtungEinleser leser = new SichtungEinleser();
        sichtungen.addAll(leser.gibSichtungen(dateiname));
    }

    /**
     * Gib die Details aller Sichtungen aus.
     */
    public void listeAusgeben()
    {
        sichtungen.forEach(sichtung -> System.out.println(sichtung.gibDetails()));
    }

    /**
     * Gib die Details aller Sichtungen des angegebenen Tiers aus.
     * @param tier  die Tierart
     */
    public void sichtungenAusgebenUeber(String tier)
    {
        sichtungen.stream()
        .filter(sichtung -> sichtung.gibTier().contains(tier))
        .forEach(sichtung -> System.out.println(sichtung.gibDetails()));        
    }

    /**
     * Gib alle Sichtungen des angegebenen Melders aus.
     * @param melder  die ID des Melders
     */
    public void sichtungenAusgebenVon(int melder)
    {
        sichtungen.stream()
        .filter(sichtung -> sichtung.gibMelder() == melder)
        .map(sichtung -> sichtung.gibDetails())
        .forEach(details -> System.out.println(details));        
    }

    /**
     * Liefere eine Zählung der Sichtungen eines gegebenen Tiers.
     * @param tier  die Tierart
     * @return      die Anzahl der Sichtungen der gegebenen Tierart
     */
    public int gibAnzahl(String tier)
    {
        return sichtungen.stream()
        .filter(sichtung -> tier.equals(sichtung.gibTier()))
        .map(sichtung -> sichtung.gibAnzahl())
        .reduce(0, (runningSum, count) -> runningSum + count);
    }

    /**
     * Liefere eine Liste aller Sichtungen einer gegebenen Tierart
     * in einer bestimmten Gegend.
     * @param tier    die Tierart
     * @param gebiet  die ID des Gebiets
     * @return        eine Liste aller Sichtungen
     */
    public Stream<Sichtung> gibSichtungenInGebiet(String tier, int gebiet)
    {
        
        return sichtungen.stream()
        .filter(sichtung -> sichtung.gibTier().contains(tier))
        .filter(s-> s.gibGebiet()==gebiet);
    }
}
