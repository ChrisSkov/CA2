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

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String additionalInfo;
    private int zip;
    private String city;
    private List<PhoneDTO> phones;
    private List<HobbyDTO> hobbies;

    public PersonDTO() {
    }

    public PersonDTO(Person p, Address a, CityInfo c, List<PhoneDTO> ph, List<HobbyDTO> ho) {
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

    public PersonDTO(int id, String firstName, String lastName, String email, String street, String additionalInfo, int zip, String city, List<PhoneDTO> phones, List<HobbyDTO> hobbies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.zip = zip;
        this.city = city;
        phones = phones;
        hobbies = hobbies;
    }

       

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.email = person.geteMail();
        this.street = person.getAddress().getStreet();
        this.additionalInfo = person.getAddress().getAdditionalInfo();
        this.city = person.getAddress().getCityInfo().getCity();
        this.zip = person.getAddress().getCityInfo().getZipCode();
        List<HobbyDTO> hobs = new ArrayList();
        for (Hobby hobby : person.getHobbies()) {
            hobs.add(new HobbyDTO(hobby));
        }
        this.hobbies = hobs;
        List<PhoneDTO> phons = new ArrayList();
        for (Phone phone : person.getPhones()) {
            phons.add(new PhoneDTO(phone));
        }
        this.phones = phons;
  
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
