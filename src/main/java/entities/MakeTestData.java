/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import static entities.Person_.address;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jacob
 */
public class MakeTestData {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try {
            Address a = new Address("hah", "akndj");
            Person p1 = new Person("had", "ahjbsjdh", "adk", a); 
            em.getTransaction().begin(); //begin transaction
            em.persist(p1);
            em.getTransaction().commit(); //commit transactions
            System.out.println(p1.getFirstName());
        } finally {
            em.close();
        }
    }
}
