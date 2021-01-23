package com.udacity.jdnd.course3.critter.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name= "CUSTOMER_ID", nullable = false,length=255)
    private Long id;

    @Nationalized
    @Column(name= "CUSTOMER_NAME",nullable = false, length = 255)
    private String name;

    @Nationalized
    @Column(name= "CONTACT_NUMBER", length = 255)
    private String phoneNumber;

    @Nationalized
    @Column(name="NOTES", length = 512)
    private String notes;

    @OneToMany( mappedBy = "owner",cascade = CascadeType.ALL)
    private List<Pet> pets;

    public Customer() { }

    public Customer(String name, String phoneNumber, String notes, List<Pet> pets) {
//        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
        this.pets = pets;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phoneNumber;
    }

    public void setPhonenumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
