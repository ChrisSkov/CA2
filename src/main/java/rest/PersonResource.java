package rest;

import DTO.PersonDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Person;
import utils.EMF_Creator;
import facades.PersonFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
                "jdbc:mysql://localhost:3307/Persons",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final PersonFacade FACADE =  PersonFacade.getPersonFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        return Response.ok().entity(GSON.toJson(FACADE.getAllPersons())).build();
    }
    
     @GET
    @Path("/allZips")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllZips() {
        return Response.ok().entity(GSON.toJson(FACADE.getAllZips())).build();
    }
    
    

//    @Path("/allPersonsHobby/{Hobby}")
//    @GET
//    @Produces({MediaType.APPLICATION_JSON})
//    public String allPersonsHobby(@PathParam("Hobby") String hobby) throws Exception {
//
//        List<PersonDTO> hobbylist = FACADE.getPersonByHobby(hobby);
//        return GSON.toJson(hobbylist);
//    }
//    
//
//
@POST
@Path("/add")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public Person create(Person entity)
    {
        Person newPerson = FACADE.addPerson(entity);
        return newPerson;

    }




}//end of class
    
//Get all persons with a given hobby
//Get all persons living in a given city (i.e. 2800 Lyngby)
//Get the count of people with a given hobby
//Get a list of all zip codes in Denmark
//Create a Person (with hobbies, phone, address etc.)
 

