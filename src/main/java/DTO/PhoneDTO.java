/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Phone;

/**
 *
 * @author artin
 */
public class PhoneDTO {

   
    private int phone;
    private String description;
    
    public PhoneDTO(Phone p) {
        this.phone = p.getNumber();
        this.description = p.getDescription();
    }
}
