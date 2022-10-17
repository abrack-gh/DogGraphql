package com.DogGraphql.DogGraphql.mutator;

import com.DogGraphql.DogGraphql.exception.BreedNotFoundException;
import com.DogGraphql.DogGraphql.exception.DogNotFoundException;
import com.DogGraphql.DogGraphql.entity.Dog;
import com.DogGraphql.DogGraphql.repository.DogRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) { this.dogRepository = dogRepository; }

    public boolean deleteDogBreed(String breed){
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        for(Dog d:allDogs){
            if(d.getBreed().equals(breed)){
                dogRepository.delete(d);
                deleted = true;
            }
        }
        if(!deleted){
            throw new BreedNotFoundException("Breed not found", breed);
        } return deleted;
    }

    public Dog updateDogName(String newName, Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()){
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog not found", id);
        }

    }
}
