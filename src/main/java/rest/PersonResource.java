package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Person;
import entities.RenameMe;
import utils.EMF_Creator;
import facades.PersonFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Todo Remove or change relevant parts before ACTUAL use
@Path("person")
public class PersonResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/Person",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final PersonFacade FACADE =  PersonFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    

@Path("/allPersonsHobby/{Hobby}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String allPersonsHobby(@PathParam("Hobby") String hobby) throws Exception {

        List<Person> hobbylist = (List<Person>) FACADE.getPersonByHobby(hobby);
        return GSON.toJson(hobbylist);
    }
    
}
    
    
//Get all persons with a given hobby
//Get all persons living in a given city (i.e. 2800 Lyngby)
//Get the count of people with a given hobby
//Get a list of all zip codes in Denmark
//Create a Person (with hobbies, phone, address etc.)
 

