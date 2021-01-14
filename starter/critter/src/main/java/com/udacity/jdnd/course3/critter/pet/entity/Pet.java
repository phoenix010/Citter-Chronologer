package com.udacity.jdnd.course3.critter.pet.entity;

import com.udacity.jdnd.course3.critter.pet.PetType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue
    private long id;
    private PetType type;
@Nationalized
    private String name;
    private long ownerId;
    private LocalDate birthDate;
    private String notes;

}
