package com.DogGraphql.DogGraphql.repository;

import com.DogGraphql.DogGraphql.entity.Dog;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class DogRepository implements CrudRepository<Dog, Long> {

    @Override
    public <S extends Dog> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Dog> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Dog> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Dog> findAll() {
        return null;
    }

    @Override
    public Iterable<Dog> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Dog entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Dog> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
