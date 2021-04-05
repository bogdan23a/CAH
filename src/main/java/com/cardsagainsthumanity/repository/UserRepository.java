package com.cardsagainsthumanity.repository;

import com.cardsagainsthumanity.entity.User;
import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    List<User> findByRoom(String room);
}
