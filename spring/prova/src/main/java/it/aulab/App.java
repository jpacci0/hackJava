package it.aulab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.aulab.model.Batman;
import it.aulab.model.Batmobile;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Batman batman = context.getBean("batman", Batman.class);
        Batmobile batmobile = context.getBean("batmobile", Batmobile.class);


        System.out.println(batman);
        System.out.println(batmobile);

    }
}
