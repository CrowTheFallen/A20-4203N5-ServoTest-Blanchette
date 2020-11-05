package org.Blanchette;
import org.Blanchette.impl.ServiceImplementation;
import org.Blanchette.interfaces.Service;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Service service = new ServiceImplementation();
        service.questionsParNombreVotes();


        System.out.println( "Hello" );
    }
}
