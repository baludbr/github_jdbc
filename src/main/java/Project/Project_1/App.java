package Project.Project_1;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException
    {
        Tomcat tomcat = new Tomcat();

        // Set the port number
        tomcat.setPort(8081);

        // Define the web application context
        String contextPath = "/Project_1";
        String docBase = new File("src/main/webapp").getAbsolutePath();

        // Add the web application context to the Tomcat server
        Context context = tomcat.addContext(contextPath, docBase);

        // Ensure JSP support is configured
        context.setDocBase(docBase);

        // Start the Tomcat server
        tomcat.start();
        tomcat.getServer().await();
    }
}
