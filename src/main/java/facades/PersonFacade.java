package facades;

import DTO.PersonDTO;
//import Exception.PersonException;
import entities.CityInfo;
import entities.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
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

    public List<PersonDTO> getAllPersons() {
        EntityManager em = getEntityManager();
        try {
            List<PersonDTO> all = new ArrayList();
            List<Person> persons = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
            for (Person person : persons) {
            all.add(new PersonDTO(person));
            }
            return all;
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

    public List<PersonDTO> getPersonByHobby(String Phobby) {
        EntityManager em = getEntityManager();
        try {   

            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p JOIN p.hobbies h WHERE h.name = :Phobby", Person.class);
            query.setParameter("pHobby", Phobby);
            List<Person> persons = query.getResultList();
            List<PersonDTO> hobby = new ArrayList<>();

            for (Person p : persons) {
                hobby.add(new PersonDTO(p));
            }
            return hobby;
        } finally {
            em.close();
        }
    }

   public List<CityInfo> getAllZips() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createNamedQuery("CityInfo.getByZip");
            List<CityInfo> results = query.getResultList();

            return results;

        } finally {
            em.close();
        }
    }
    public List<PersonDTO> findByZip(int zip) {
        EntityManager em = getEntityManager();

        try {
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p JOIN p.address.cityInfo c WHERE c.zipCode = :zipCode", Person.class);
            query.setParameter("zipCode", zip);
            List<Person> persons = query.getResultList();
            List<PersonDTO> zipCode = new ArrayList<>();
            for (Person p : persons) {
                zipCode.add(new PersonDTO(p));
            }
            return zipCode;
        } finally {
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

    public String deletePerson(int ID) {

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

//    public PersonDTO editPerson(Person p) {
//               EntityManager em = emf.createEntityManager();
//            em.getTransaction().begin();
//            try{
//                em.merge(p);
//            } catch(Exception e){
//                
//            }
//            em.getTransaction().commit();
//            em.close();
//            return new PersonDTO(p);
//
//    }

}
    

