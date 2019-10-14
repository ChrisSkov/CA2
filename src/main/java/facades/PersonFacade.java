package facades;

import entities.CityInfo;
import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.WebApplicationException;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class PersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private PersonFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Person getPersonByLastName(String name) throws Exception {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT FROM Person p WHERE p.lastName = :lastName", Person.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Non found by that name");
        } finally {
            em.close();
        }
    }

    public Person getPersonByFirstName(String name) throws Exception {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT FROM Person p WHERE p.firstName = :firstName", Person.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Non found by that name");
        } finally {
            em.close();
        }
    }

    public Person getPersonById(int Id) throws Exception {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Person p WHERE p.id = :id", Person.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Non found by that id");
        } finally {
            em.close();
        }
    }
    
    public Person getPersonByPhoneNumber(int phoneNumber) throws Exception {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Person p WHere p.phones = :phones", Person.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("None found by that number");
        } finally {
            em.close();
        }
    }
    
    public  List<Person> getPersonByHobby(String name) throws Exception {
        EntityManager em = getEntityManager();
        try{
            return (List<Person>) em.createQuery("SELECT p FROM Person p JOIN p.hobbies h WHERE h.name = :name",Person.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("None found with that hobby");
        } finally {
            em.close();
        }
    }
    
    public Person getAllPersonFromCity(String cityName) throws Exception {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT p FROM Person p Where p.address = :address", Person.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("none from that city");
        }finally {
            em.close();
        }
    }
    
    public CityInfo getAllZips(int zipCode) throws Exception {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("Select c FROM CityInfo c WHERE c.zipCode = :zipCode", CityInfo.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("none from that city");
        }finally {
            em.close();
        }
    }
    
        public Person addPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            return person;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return person;
    }
        
        public String deletePerson(int ID){
            
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Person person = em.find(Person.class, ID);
            em.remove(person);
            em.getTransaction().commit();
            return "Removed person name: " + person.getId();
        } catch (Exception ex) { // Thrown by em.commit()
            throw new WebApplicationException("Database error when deleting person.", 500);
        } finally {
            em.close();
        }
    }
            
    
}
