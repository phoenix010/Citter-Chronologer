package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.entity.Pet;

import java.util.List;

/**
 * Represents the form that customer request and response data takes. Does not map
 * to the database directly.
 */
public class CustomerDTO {
//    private long id;
    private String name;
    private String phoneNumber;
    private String notes;
    private List<Pet> pets;
    private String ssn;

    public CustomerDTO(String name, String phoneNumber, String notes, List<Pet> pets, String ssn) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
        this.pets = pets;
        this.ssn = ssn;
    }

    //    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPet(List<Pet> pets) {
        this.pets = pets;
    }
}
