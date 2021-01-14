package com.udacity.jdnd.course3.critter.user.entity;

import javax.persistence.*;
import java.util.List;
@Entity
//@Table(name="customertable")
public class Customer {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String phoneNumber;
    private String notes;
    @ElementCollection
    private List<Long> petIds;
}
