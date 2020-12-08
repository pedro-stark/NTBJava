package src.CollectionsLoesung.u2_2_Lambdas_BlueJ.tiermoni_v1;

/**
 * Details der Sichtung einer Tierart, jeweils von einem Melder übermittelt.
 * 
 * @author David J. Barnes und Michael Kölling
 * @version 2016.02.29
 */
public class Sichtung
{
    // Das gemeldete Tier.
    private final String tier;
    // Die ID des Melders.
    private final int melder;
    // Anzahl der gesichteten Tiere.
    private final int anzahl;
    // The ID of the area in which they were seen.
    private final int gebiet;
    // The reporting period.
    private final int zeitraum;
    
    /**
     * Erzeuge einen Datensatz einer Sichtung einer bestimmten Tierart.
     * @param tier      das gemeldete Tier
     * @param melder    die ID des Melders
     * @param anzahl    die Anzahl der gesichteten Tiere (>= 0)
     * @param gebiet    die ID des Sichtungsgebiets 
     * @param zeitraum  der Berichtszeitraum
     */
    public Sichtung(String tier, int melder, int anzahl, int gebiet, int zeitraum)
    {
        this.tier = tier;
        this.melder = melder;
        this.anzahl = anzahl;
        this.gebiet = gebiet;
        this.zeitraum = zeitraum;
    }

    /**
     * Liefere die gesichtete Tierart.
     * @return  die Tierart
     */
    public String gibTier() 
    {
        return tier;
    }

    /**
     * Liefere die ID des Melders.
     * @return  die ID des Melders 
     */
    public int gibMelder() 
    {
        return melder;
    }

    /**
     * Liefere die Anzahl der gesichteten Tiere.
     * @return  die Anzahl der gesichteten Tiere
     */
    public int gibAnzahl() 
    {
        return anzahl;
    }

    /**
     * Liefere die ID des Sichtungsgebiets.
     * @return  Sichtungsgebiet
     */
    public int gibGebiet() 
    {
        return gebiet;
    }

    /**
     * Liefere den Zeitraum, in dem die Sichtung stattfand.
     * @return  Sichtungszeitraum
     */
    public int gibZeitraum() 
    {
        return zeitraum;
    }

    /**
     * Liefere einen String, der die Details zum Tier enthält: gesichtete Anzahl,
     * Sichtungsort, wer die Tiere gemeldet hat, wo und wann sie gesichtet wurden.
     * @return  einen String, der die Details zur Sichtung angibt
     */
    public String gibDetails() 
    {
        return tier + 
               ", Anzahl = " + anzahl + 
               ", Gebiet = " + gebiet + 
               ", Melder = " + melder + 
               ", Zeitraum = " + zeitraum;
    }
    
}
