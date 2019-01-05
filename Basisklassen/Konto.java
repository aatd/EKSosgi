package de.thkoeln.eksa.osgi.entitaetsklassen;

public class Konto
{
    private int kontonr;

    public Konto(){}

    //Getter setter
    public int getKontonummer()
    { return this.kontonr; }
    
    public void setKontonummer(int kontonr)
    { this.kontonr = kontonr; }
}