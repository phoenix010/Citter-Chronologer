package com.udacity.jdnd.course3.critter.service.impl;

import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.exception.ObjectNotFoundException;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import com.udacity.jdnd.course3.critter.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Customer owner = pet.getOwner();
        if(owner != null){
            Optional<Customer> ownerOptional = customerRepository.findById(owner.getId());
            if(ownerOptional.isPresent()){
                petRepository.save(pet);
                owner = ownerOptional.get();
                owner.getPets().add(pet);
            }else{
                throw new ObjectNotFoundException("Customer not found");
            }
        }
//        petRepository.save(pet);
        return pet;
    }

    @Override
    public Pet getPetById(long id) {
        Optional<Pet> pet = petRepository.findById(id);
        if(pet.isPresent()){
            return pet.get();
        }else{
            throw new ObjectNotFoundException("pet not found");
        }
    }

    @Override
    public List<Pet> getAllPets() {
        List<Pet> petList =  petRepository.findAll();
        if(petList.size()== 0){
            throw new ObjectNotFoundException("Pet List is zero");
        }
        return petList;
    }

    @Override
    public List<Pet> getAllByOwnerId(long ownerId) {
        return null;
    }
}
