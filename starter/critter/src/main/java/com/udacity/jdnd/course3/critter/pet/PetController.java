package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.exception.ObjectNotFoundException;
import com.udacity.jdnd.course3.critter.service.impl.CustomerServiceImpl;
import com.udacity.jdnd.course3.critter.service.impl.PetServiceImpl;
import com.udacity.jdnd.course3.critter.entity.Pet;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    PetServiceImpl petService;
    CustomerServiceImpl customerService;

    @Autowired
    public PetController(PetServiceImpl petService, CustomerServiceImpl customerService) {
        this.petService = petService;
        this.customerService = customerService;
    }

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        /**
         * Validate if the customer exists. if excists, then save the pet otherewise return the error msg back as response.
         */
        System.out.println("working on PET POST REQ");
        Pet pet = convertPetDTOtoEntity(petDTO);
        return convertEntityToPetDTO(petService.savePet(pet));
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping
    public List<PetDTO> getPets(){
        throw new UnsupportedOperationException();
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        throw new UnsupportedOperationException();
    }

    private Pet convertPetDTOtoEntity(PetDTO petDTO){
        String petName = petDTO.getName();
        PetType petType = petDTO.getType();
        Customer owner = petDTO.getOwner();
        LocalDate birthDate = petDTO.getBirthDate();
        String notes = petDTO.getNotes();
        return new Pet(petName,owner,petType,birthDate,notes);
    }
    private PetDTO convertEntityToPetDTO(Pet pet){
        PetType petType = pet.getType();
        String name = pet.getName();
        Customer owner = pet.getOwner();
        LocalDate birthDate = pet.getBirthDate();
        String notes = pet.getNotes();
        return new PetDTO(petType,name,owner,birthDate,notes);
     }
}
