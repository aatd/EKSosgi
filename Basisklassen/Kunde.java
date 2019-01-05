package de.thkoeln.eksa.osgi.entitaetsklassen;

import java.util.ArrayList;

public class Kunde
{
    private String name;
    private int kundennummer;
    private ArrayList<Integer> konten;

    public Kunde(){}

    //Getter setter
    public int getKundennummer()
    {  return this.kundennummer;  }

    public void setKundennummer(int kundennummer)
    {  this.kundennummer = kundennummer;  }
    
    public String getName()
    { return this.name; }

    public void setName(String name)
    { this.name = name; }

    public ArrayList<Integer> getKonten()
    { return this.konten; }

    public void setKonten(ArrayList<Integer> konten)
    { this.konten = konten; }
}