package de.thkoeln.eksa.osgi.verwaltung;

import de.thkoeln.eksa.osgi.entitaetsklassen.Kunde;
import de.thkoeln.eksa.osgi.entitaetsklassen.Konto;

import java.util.ArrayList;

public interface KundeKontoVerwaltung 
{
    /**
     * Erzeugt ein neues Objekt der Klasse Kunde.      
     * Hierbei muss auf das Interface NummernSpeicher       
     * zugegriffen werden, um eine neue Kundennummer zu erhalten.           
     *       
     * @param name Name des neuen Kunden      
     *      
     * @return vergebene Kundennummer      
     */ 
    public int neuerKunde(String name);

    /**
     * Das Kundenobjekt zur gegebenen Kundennummer wird      
     * zurückgegeben.      
     *       
     * @param kundenr Kundennummer des gesuchten Kundenobjekts      
     *       
     * @return Objekt der Klasse Kunde mit der Kundenummer kundenr      
     */
    public Kunde getKunde(int kundenr); 

    /**
     * Liefert alle Konten des gegebenen Kunden.     
     *        
     * @param k Kundenobjekt, für das die Konten       
     * ermittelt werden sollen      
     *      
     * @return Liste aller Konten des Kunden k.      
     */
    public ArrayList<Konto> alleKonten(Kunde k);

    /**
     * Es wird der Kundenverwaltung mitgeteilt, dass       
     * der Kunde k nun das Konto mit der      
     * Kontonummer kontonr besitzt.     
     *      
     * @param k Kunde, der das neue Konto besitzt     
     *       
     * @param kontonr Kontonummer des neuen Kontos des Kunden k      
     */ 
    public void besitztKonto (Kunde k, int kontonr);

    /**
     * Erzeugt ein neues Objekt der Klasse Konto.      
     * Hierbei muss auf das Interface NummernSpeicher       
     * zugegriffen werden, um eine neue Kontonummer zu erhalten. 
     * 
     * @return vergebene Kontonummer      
     */ 
    public int neuesKonto(); 

}