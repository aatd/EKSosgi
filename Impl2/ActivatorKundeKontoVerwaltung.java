package de.thkoeln.eksa.osgi.impl.kundekontoverwaltung;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration; 

import de.thkoeln.eksa.osgi.verwaltung.KundeKontoVerwaltung;
import de.thkoeln.eksa.osgi.impl.kundekontoverwaltung.ImplKundeKontoVerwaltung;

public class ActivatorKundeKontoVerwaltung implements BundleActivator
{
	private ServiceRegistration verwaltungsService;
    
    public void start(BundleContext context)
    {
        Hashtable<String, String> props = new Hashtable<String, String>();

        props.put("Verwaltung", "KundeKontoVerwaltung");

        verwaltungsService = context.registerService(   
                                                        KundeKontoVerwaltung.class.getName(), 
                                                        ImplKundeKontoVerwaltung.getInstance(context), 
                                                        props
                                                    );
        
        System.out.println("Hallo ich bin die Verwaltung!");
    }
    
    public void stop(BundleContext context)
    {
        verwaltungsService.unregister();
	    System.out.println("Tschuess, die Verwaltung verabschiedet sich!");
    }
}
