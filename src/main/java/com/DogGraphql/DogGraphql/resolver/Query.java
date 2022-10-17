package com.DogGraphql.DogGraphql.resolver;

import com.DogGraphql.DogGraphql.exception.DogNotFoundException;
import com.DogGraphql.DogGraphql.entity.Dog;
import com.DogGraphql.DogGraphql.repository.DogRepository;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.Optional;


@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDog() {
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if(optionalDog.isPresent()){
            return optionalDog.get();
        } else {
            throw new DogNotFoundException("Dog not found", id);
        }
    }
}

