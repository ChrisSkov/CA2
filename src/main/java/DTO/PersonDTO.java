package DTO;

import entities.Address;
import entities.CityInfo;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author stoff
 */
public class PersonDTO {
    
    
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String additionalInfo;
    private int zip;
    private String city;
    private List<PhoneDTO> phones;
    private List<HobbyDTO> hobbies;

    public PersonDTO()
    {
    }

    public PersonDTO(Person p, Address a, CityInfo c, List<PhoneDTO> ph, List<HobbyDTO>ho) 
    {
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        this.email = p.geteMail();
        this.street = a.getStreet();
        this.additionalInfo = a.getAdditionalInfo();
        this.zip = c.getZipCode();
        this.city = c.getCity();
        this.phones = ph;
        this.hobbies = ho;
   
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }

    public List<HobbyDTO> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<HobbyDTO> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", street=" + street + ", additionalInfo=" + additionalInfo + ", zip=" + zip + ", city=" + city + ", phones=" + phones + ", hobbies=" + hobbies + '}';
    }

   
}
