package de.thkoeln.eksa.osgi.consumer;

import java.util.ArrayList;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import de.thkoeln.eksa.osgi.verwaltung.KundeKontoVerwaltung;
import de.thkoeln.eksa.osgi.entitaetsklassen.*;

public class Anwendung implements BundleActivator
{
    public void start(BundleContext context) throws Exception
    {
  
        ServiceReference ref = 
        context.getServiceReference(KundeKontoVerwaltung.class.getName());

        if (ref != null)
        {
            try
            {
                System.out.println("Verwaltung erfolgreich geladen!\n\n\n\n");
                
                KundeKontoVerwaltung kundeKontoVerwaltungsService = 
                    (KundeKontoVerwaltung) context.getService(ref);
 
                int kunde1 = kundeKontoVerwaltungsService.neuerKunde("Tim"); 
                System.out.println("Kunde Tim hat Kundennummer: " + kunde1); 
                   
                int kunde2 = kundeKontoVerwaltungsService.neuerKunde("Stephan"); 
                System.out.println("Kunde Stephan hat Kundennummer: " + kunde2); 
                    
                int konto1 = kundeKontoVerwaltungsService.neuesKonto(); 
                System.out.println("Kontonummer von Konto 1: " + konto1); 
                    
                int konto2 = kundeKontoVerwaltungsService.neuesKonto(); 
                System.out.println("Kontonummer von Konto 2: " + konto2); 
        
                int konto3 = kundeKontoVerwaltungsService.neuesKonto(); 
                System.out.println("Kontonummer von Konto 3: " + konto3); 
        
                Kunde kundenObjekt1 = kundeKontoVerwaltungsService.getKunde(kunde1); 
                Kunde kundenObjekt2 = kundeKontoVerwaltungsService.getKunde(kunde2);     
        
                kundeKontoVerwaltungsService.besitztKonto(kundenObjekt1, konto1); 
                kundeKontoVerwaltungsService.besitztKonto(kundenObjekt1, konto2); 
                kundeKontoVerwaltungsService.besitztKonto(kundenObjekt2, konto3); 
        
                ArrayList<Konto> timskonten = kundeKontoVerwaltungsService.alleKonten(kundenObjekt1); 
                System.out.println("Alle gefundenen Konten von Tim:"); 
                for (Konto k : timskonten) 
                {   
                    System.out.print(k.getKontonummer());   
                    System.out.println(); 
                } 
                
                ArrayList<Konto> stephanskonten = kundeKontoVerwaltungsService.alleKonten(kundenObjekt2); 
                System.out.println("Alle gefundenen Konten von Stephan:"); 
                for (Konto k : stephanskonten) 
                {   
                    System.out.print(k.getKontonummer());   
                    System.out.println(); 
                }
            } catch (Exception e) { }
        }
        else
        {
            System.out.println("");
        }
    }

    public void stop(BundleContext context)
    {
        System.out.println("Consumer sagt Tschuess zur Verwaltung!");
    }


        
}

