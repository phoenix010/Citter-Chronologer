package com.udacity.jdnd.course3.critter.service.impl;

import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    PetRepository petRepository;
    CustomerRepository customerRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository, CustomerRepository customerRepository) {
        this.petRepository = petRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public Pet savePet(Pet pet) {






        return null;
    }

    @Override
    public Pet getPetById(long id) {
        return null;
    }

    @Override
    public List<Pet> getAllPets() {
        return null;
    }

    @Override
    public List<Pet> getAllByOwnerId(long ownerId) {
        return null;
    }
}
