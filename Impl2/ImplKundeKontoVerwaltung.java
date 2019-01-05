package de.thkoeln.eksa.osgi.impl.kundekontoverwaltung;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.io.IOException;
import java.util.ArrayList;

import de.thkoeln.eksa.osgi.verwaltung.KundeKontoVerwaltung;
import de.thkoeln.eksa.osgi.entitaetsklassen.Kunde;
import de.thkoeln.eksa.osgi.entitaetsklassen.Konto;
import de.thkoeln.eksa.osgi.sonstigedienste.Nummernspeicher; 

public class ImplKundeKontoVerwaltung implements KundeKontoVerwaltung
{   
     private static ImplKundeKontoVerwaltung kw;
     private Nummernspeicher nummernspeicherService;
     private ArrayList<Kunde> alleKunden;
     private ArrayList<Konto> alleKonten;

     /*Singleton*/
     private ImplKundeKontoVerwaltung(BundleContext context) throws Exception
     {
          alleKunden = new ArrayList<Kunde>();
          alleKonten = new ArrayList<Konto>();
          
          //Get Nummernspeicher als Service
          ServiceReference ref = 
          context.getServiceReference(Nummernspeicher.class.getName());

          //if(ref != null)
          //{
               try{
                    nummernspeicherService = (Nummernspeicher) context.getService(ref);
                    System.out.println("Nummernspeicher wurde geladen.");

               } catch (Exception e){}
          //}
          //else
          //{
          //     System.out.println("Nummernspeicher konnte nicht geladen werden.");
          //}
     }
     public static ImplKundeKontoVerwaltung getInstance(BundleContext context)
     {
          if(kw == null)
          {
               try{
                    return kw = new ImplKundeKontoVerwaltung(context); 
               }catch (Exception e){}
          }

          return kw;
     }

     public int neuerKunde(String name)
     {
          //init
          Kunde k = new Kunde();
          int kundennummer = nummernspeicherService.getNeueKundenNr();

          //define
          k.setName(name);
          k.setKundennummer(kundennummer);

          //put
          alleKunden.add(k);

          return k.getKundennummer();
     }
     
     public Kunde getKunde(int kundenr)
     {
          Kunde tmp = new Kunde();

          for(Kunde k: alleKunden)
          {
               if (k.getKundennummer() == kundenr)
               {
                    tmp = k;
                    break;
               }
          }
          return tmp;
     } 
     
     public int neuesKonto()
     {
          //init
          Konto k = new Konto();
          int nr = nummernspeicherService.getNeueKontoNr();

          //define
          k.setKontonummer(nr);

          //put
          alleKonten.add(k);

          return nr;
     }

     public ArrayList<Konto> alleKonten(Kunde k)
     {
          ArrayList<Konto> tmp = new ArrayList<Konto>();
          ArrayList<Integer> kundenKonten = k.getKonten();

          for (Konto konto : alleKonten) 
          {
               for (Integer i : kundenKonten)
               {
                    if(konto.getKontonummer() == i)
                    {
                         tmp.add(konto);
                    }                    
               }
          }

          return tmp;
     }
     
     public void besitztKonto (Kunde k, int kontonr)
     {
          Kunde kunde = getKunde(k.getKundennummer());    

          if(k.getKonten() == null)
          {
               ArrayList<Integer> tmp = new ArrayList<Integer>();
               tmp.add(kontonr);
               k.setKonten(tmp);
          }
          else
          {
               k.getKonten().add(kontonr);
          }
     }
}