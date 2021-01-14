package com.udacity.jdnd.course3.critter.user.entity;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
//import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Set;

@Entity
//@Table(name = "employeedata")
public class Employee {
    @Id
    @GeneratedValue
    private long id;

//    private String name;
    @ElementCollection
    private Set<EmployeeSkill> skills;
    @ElementCollection
    private Set<DayOfWeek> daysAvailable;


}
