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

    private int id;
    private String name;
    private String street;
    private String city;
    private String zip;
    private List<Hobby> hobbies = new ArrayList<>();
    private List<Phone> phones = new ArrayList<>();
    
    
}
