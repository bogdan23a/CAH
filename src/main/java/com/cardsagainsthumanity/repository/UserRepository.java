package com.cardsagainsthumanity.repository;

import com.cardsagainsthumanity.entity.User;
import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    @Executable
    Collection<User> findByRoomToken(String roomToken);
    @Executable
    User findByName(String name);
}
