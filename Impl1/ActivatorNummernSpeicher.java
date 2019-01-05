package de.thkoeln.eksa.osgi.impl.nummernspeicher;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration; 

import de.thkoeln.eksa.osgi.sonstigedienste.Nummernspeicher;
import de.thkoeln.eksa.osgi.impl.nummernspeicher.ImplNummernSpeicher;

public class ActivatorNummernSpeicher implements BundleActivator
{
	private ServiceRegistration nummernspeicherService;
    
    public void start(BundleContext context)
    {
        Hashtable<String, String> props = new Hashtable<String, String>();

        props.put("SonsitgeDienste", "Nummernspeicher");

        nummernspeicherService = context.registerService(   
                                                        Nummernspeicher.class.getName(), 
                                                        ImplNummernSpeicher.getInstance(), 
                                                        props
                                                    );
        
        System.out.println("Hallo ich bin der Nummernspeicher!");

    }
    
    public void stop(BundleContext context)
    {
        nummernspeicherService.unregister();
	    System.out.println("Tschuess, der Nummernspeicher verabschiedet sich!");
    }
}
