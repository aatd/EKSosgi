package de.thkoeln.eksa.osgi.impl.nummernspeicher;

import de.thkoeln.eksa.osgi.sonstigedienste.Nummernspeicher;

public class ImplNummernSpeicher implements Nummernspeicher
{
    private int kontozeahler, kundenzaehler;
    private static ImplNummernSpeicher ns;

    /*Singleton*/
    private ImplNummernSpeicher()
    {
        this.kontozeahler  = 0;
        this.kundenzaehler = 0;
    }
    public static ImplNummernSpeicher getInstance()
    {
        if(ns == null)
            return ns = new ImplNummernSpeicher(); 
        else
            return ns; 
    }

    public int getNeueKontoNr()
    {
        return this.kontozeahler++;
    }
    
    public int getNeueKundenNr()
    {
        return this.kundenzaehler++;
    }
}