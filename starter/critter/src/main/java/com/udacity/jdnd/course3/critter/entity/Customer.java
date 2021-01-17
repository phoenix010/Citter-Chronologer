package com.udacity.jdnd.course3.critter.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "CUSTOMER_ID", nullable = false,length=255)
    private Long id;

    @Nationalized
    @Column(name= "CUSTOMER_NAME", length = 255)
    private String name;

    @Nationalized
    @Column(name= "CONTACT_NUMBER", length = 255)
    private String phoneNumber;

    @Nationalized
    @Column(name="NOTES", length = 512)
    private String notes;

    @Nationalized
    @Column(name="CUSTOMER_SSN", nullable = false, unique = true, length = 9)
    private String ssn;

    @OneToMany(mappedBy = "customer", targetEntity = Pet.class, cascade = CascadeType.ALL)
    private List<Pet> pets;

    public Customer() { }

    public Customer(String name, String phoneNumber, String notes, List<Pet> pets, String ssn) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.notes = notes;
        this.pets = pets;
        this.ssn = ssn;
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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }


}
