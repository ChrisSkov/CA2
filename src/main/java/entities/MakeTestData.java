/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import static entities.Person_.address;
import facades.PersonFacade;
import java.util.ArrayList;
import java.util.List;
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
            Address a = new Address("greve", "10");
            Address b = new Address("greve", "10");
            Address c = new Address("greve", "10");
                      
            CityInfo c1 = new CityInfo(2200, "Nørrebro");
            CityInfo c2 = new CityInfo(2660, "Brøndby Strand");
            CityInfo c3 = new CityInfo(2300, "Nebro");
            CityInfo c4 = new CityInfo(2100, "bro");
            
            Hobby h1 = new Hobby("football", "kicking");
            Hobby h2 = new Hobby("baseball", "hitting");
            Hobby h3 = new Hobby("basket", "hoophooop");
            Hobby h4 = new Hobby("run", "running");
            
            Phone ph1 = new Phone(50438269, "mobile");
//            Phone ph2 = new Phone(13232434, "mobile");
//            Phone ph3 = new Phone(42452451, "mobile");
//            Phone ph4 = new Phone(25245443, "mobile");
            
            List<Hobby>hob = new ArrayList();
            hob.add(h1);
            hob.add(h2);
            hob.add(h3);
            hob.add(h4);
            
            List<Phone>pho = new ArrayList();
            pho.add(ph1);
//            pho.add(ph2);
//            pho.add(ph3);
//            pho.add(ph4);
            
            
            
            Person p1 = new Person("ahd@lvie.dk","haamd", "shag", a, hob, pho);
//            Person p2 = new Person("Jabs@gmail.com", "jabs", "jabr", a);
//            Person p3 = new Person("Jabs@gmail.com", "jabs", "jabr", a);
//            Person p4 = new Person("Jabs@gmail.com", "jabs", "jabr", a);
//            
            
            
            
            em.getTransaction().begin(); //begin transaction
            em.persist(p1);
            em.getTransaction().commit(); //commit transactions
            System.out.println(p1.getFirstName());
        } finally {
            em.close();
        }
    }
}
