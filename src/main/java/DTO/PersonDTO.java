/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Hobby;
import entities.Phone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stoff
 */
public class PersonDTO {
    
    
      private String name;
    private String email;
    private String address;
    private List<PhoneDTO> phones;
    private List<HobbyDTO> hobbies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "PersonDTO{" + "name=" + name + ", email=" + email + ", address=" + address + ", phones=" + phones + ", hobbies=" + hobbies + '}';
    }

}
