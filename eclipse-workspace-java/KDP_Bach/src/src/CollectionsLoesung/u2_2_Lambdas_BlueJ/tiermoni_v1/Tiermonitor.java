package src.CollectionsLoesung.u2_2_Lambdas_BlueJ.tiermoni_v1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Monitor-Auszählungen von verschiedenen Tierarten.
 * Sichtungen werden von Meldern aufgezeichnet.
 * 
 * @author David J. Barnes und Michael Kölling
 * @version 2016.02.29 (imperative Version)
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
        for(Sichtung datensatz : sichtungen) {
            System.out.println(datensatz.gibDetails());
        }
    }
    
    /**
     * Gib die Details aller Sichtungen des angegebenen Tiers aus.
     * @param tier  die Tierart
     */
    public void sichtungenAusgebenUeber(String tier)
    {
        for(Sichtung datensatz : sichtungen) {
            if(tier.equals(datensatz.gibTier())) {
                System.out.println(datensatz.gibDetails());
            }
        }
    }
    
    /**
     * Gib alle Sichtungen des angegebenen Melders aus.
     * @param melder  die ID des Melders
     */
    public void sichtungenAusgebenVon(int melder)
    {
        for(Sichtung datensatz : sichtungen) {
            if(datensatz.gibMelder() == melder) {
                System.out.println(datensatz.gibDetails());
            }
        }        
    }
    
    /**
     * Gib eine Liste der Tierarten aus, die als gefährdet gelten.
     * @param tiernamen             eine Liste von Tiernamen
     * @param gefaehrdungsschwelle  alle Tierarten, deren Anzahl weniger oder gleich
     *                              dieses Werts ist, gelten als gefährdet
     */
    public void gefaerdeteArtenAusgeben(ArrayList<String> tiernamen, 
                                int gefaehrdungsschwelle)
    {
        for(String tier : tiernamen) {
            if(gibAnzahl(tier) <= gefaehrdungsschwelle) {
                System.out.println(tier + " ist gefährdet.");
            }
        }
    }
    
    /**
     * Liefere eine Zählung der Sichtungen eines gegebenen Tiers.
     * @param tier  die Tierart
     * @return      die Anzahl der Sichtungen der gegebenen Tierart
     */
    public int gibAnzahl(String tier)
    {
        int total = 0;
        for(Sichtung sichtung : sichtungen) {
            if(tier.equals(sichtung.gibTier())) {
                total = total + sichtung.gibAnzahl();
            }
        }
        return total;
    }
    
    /**
     * Entferne aus der sichtungen-Liste alle Datensätze  
     * mit Anzahl null.
     */
    public void entferneNullAnzahl()
    {
        Iterator<Sichtung> it = sichtungen.iterator();
        while(it.hasNext()) {
            Sichtung datensatz = it.next();
            if(datensatz.gibAnzahl() == 0) {
                it.remove();
            }
        }
    }
    
    /**
     * Liefere eine Liste aller Sichtungen einer gegebenen Tierart
     * in einer bestimmten Gegend.
     * @param tier    die Tierart
     * @param gebiet  die ID des Gebiets
     * @return        eine Liste aller Sichtungen
     */
    public ArrayList<Sichtung> gibSichtungenInGebiet(String tier, int gebiet)
    {
        ArrayList<Sichtung> datensaetze = new ArrayList<>();
        for(Sichtung datensatz : sichtungen) {
            if(tier.equals(datensatz.gibTier())) {
                if(datensatz.gibGebiet() == gebiet) {
                    datensaetze.add(datensatz);
                }
            }
        }
        return datensaetze;
    }
    
    /**
     * Liefere eine Liste aller Sichtungen des gegebenen Tiers.
     * @param tier  die Tierart
     * @return      eine Liste aller Sichtungen der angegebenen Tierart
     */
    public ArrayList<Sichtung> gibSichtungenVon(String tier)
    {
        ArrayList<Sichtung> gefiltert = new ArrayList<>();
        for(Sichtung datensatz : sichtungen) {
            if(tier.equals(datensatz.gibTier())) {
                gefiltert.add(datensatz);
            }
        }
        return gefiltert;
    }
    
    
    public static void main(String[] args) {
    	Tiermonitor tm = new Tiermonitor();
    	
    	//TODO hier werden die Funktionen aufgerufen
    }
}
