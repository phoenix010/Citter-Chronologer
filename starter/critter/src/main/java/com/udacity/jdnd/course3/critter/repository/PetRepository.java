package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entity.Pet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PetRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Pet pet){
        entityManager.persist(pet);
    }

    public Pet find(Long id){
        return entityManager.find(Pet.class, id);
    }
    public Pet merge(Pet pet){
        return entityManager.merge(pet);
    }
    public void delete(Long id){
        Pet pet = entityManager.find(Pet.class, id);
        entityManager.remove(pet);
    }

}
