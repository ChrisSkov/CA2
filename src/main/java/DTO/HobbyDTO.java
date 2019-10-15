/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Hobby;

/**
 *
 * @author artin
 */
public class HobbyDTO {
    
    
    private String name;
    private String description;

    public HobbyDTO(Hobby h) {
        this.name = h.getName();
        this.description = h.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "HobbyDTO{" + "name=" + name + ", description=" + description + '}';
    }
    
    
    
    
}
