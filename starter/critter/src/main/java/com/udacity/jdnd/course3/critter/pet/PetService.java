package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    public void save(Pet pet){
        petRepository.persist(pet);
    }
}
