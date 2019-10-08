/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author stoff
 */
@Entity
@NamedQuery(name = "Person.deleteAllRows", query = "DELETE from Person")
public class Person implements Serializable {
//TODO ADD relations
//TODO ADD proper constructor and more getters and setter

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String eMail;
    private String firstName;
    private String lastName;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Hobby> hobbies = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "person")
    private List<Phone> phones = new ArrayList<>();
    
    public Person () {
        
    }

    public Person(String eMail, String firstName, String lastName, Address address)
    {
        this.eMail = eMail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }


    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public List<Hobby> getHobbies()
    {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies)
    {
        this.hobbies = hobbies;
    }

    public List<Phone> getPhones()
    {
        return phones;
    }

    public void setPhones(List<Phone> phones)
    {
        this.phones = phones;
    }

    public String geteMail()
    {
        return eMail;
    }

    public void seteMail(String eMail)
    {
        this.eMail = eMail;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.eMail);
        hash = 29 * hash + Objects.hashCode(this.firstName);
        hash = 29 * hash + Objects.hashCode(this.lastName);
        hash = 29 * hash + Objects.hashCode(this.address);
        hash = 29 * hash + Objects.hashCode(this.hobbies);
        hash = 29 * hash + Objects.hashCode(this.phones);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Person other = (Person) obj;
        if (this.id != other.id)
        {
            return false;
        }
        if (!Objects.equals(this.eMail, other.eMail))
        {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName))
        {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName))
        {
            return false;
        }
        if (!Objects.equals(this.address, other.address))
        {
            return false;
        }
        if (!Objects.equals(this.hobbies, other.hobbies))
        {
            return false;
        }
        if (!Objects.equals(this.phones, other.phones))
        {
            return false;
        }
        return true;
    }

}
