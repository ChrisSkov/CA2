package facades;

import DTO.PersonDTO;
import entities.Address;
import entities.Person;
import utils.EMF_Creator;
import entities.RenameMe;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Settings;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class PersonFacadeTest {

    private static EntityManagerFactory emf;
    private static PersonFacade facade;

    public PersonFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/startcode_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
        facade = PersonFacade.getPersonFacade(emf);
    }



    /*   **** HINT **** 
        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
        ONE COMMON place accessible from anywhere.
        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
        See below for how to use these files. This is our RECOMENDED strategy
     */
    @BeforeAll
    public static void setUpClassV2() {
       emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST,Strategy.DROP_AND_CREATE);
       facade = PersonFacade.getPersonFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
//    @BeforeEach
//    public void setUp() {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
//            em.persist(new RenameMe("Some txt", "More text"));
//            em.persist(new RenameMe("aaa", "bbb"));
//
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//    }
    
     @Test
    public void testGetPersonByFirstName() {
        Address c = new Address("trane", "10");
        Person per = new Person("jabs@gmail", "jabs", "jabr", c); 
        try {
            Person result = facade.getPersonByFirstName("jabs");
            Person expected = per; 
            assertEquals(expected, result);
           
        } catch (Exception ex) {
            Logger.getLogger(PersonFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test 
    public void testGetPersonById() {
        try { 
            Person p = facade.getPersonById(1);
            assertEquals(p.getFirstName(), "jabs");
        } catch (Exception ex) {
            Logger.getLogger(PersonFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @Test 
//    public void testGetPersonByPhoneNumber() {
//        try { 
//            Person p = facade.getPersonByPhoneNumber(22334477);
//            assertEquals(p.getFirstName(), "jabs"); 
//        } catch (Exception ex) {
//            Logger.getLogger(PersonFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
    
    @Test 
    public void testGetPersonByHobby() {
        try { 
            Person p = (Person) facade.getPersonByHobby("Gaming");
            assertEquals(p.getFirstName(), "jabs");
        } catch (Exception ex) {
            Logger.getLogger(PersonFacadeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterEach
    public void tearDown() {
//       Remove any data after each test was run
    }

    

   
}

