package rest;

import java.util.Set;
import javax.ws.rs.core.Application;
import Exception.GenericExceptionMapper;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
       // resources.add(Exception.GenericExceptionMapper.class);
        resources.add(filter.CorsRequestFilter.class);
        resources.add(filter.CorsResponseFilter.class);
        resources.add(org.glassfish.jersey.server.wadl.internal.WadlResource.class);
        resources.add(rest.PersonResource.class);
    }
    
}
