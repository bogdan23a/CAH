package com.cardsagainsthumanity.service;

import com.cardsagainsthumanity.entity.User;
import com.cardsagainsthumanity.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Singleton
public class UserService {

    @Inject
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<User> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Collection<User> findAllInRoom(String roomToken) {
        return  userRepository.findByRoomToken(roomToken);
    }

    public Optional<User> save(String userName) {
        User user = new User();
        user.setName(userName);
        return Optional.of(userRepository.save(user));
    }
}
