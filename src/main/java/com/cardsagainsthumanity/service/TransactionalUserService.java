package com.cardsagainsthumanity.service;

import com.cardsagainsthumanity.entity.User;
import com.cardsagainsthumanity.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Singleton
public class TransactionalUserService {

    @Inject
    private UserRepository userRepository;

    public TransactionalUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public Optional<User> saveAsHost(User user) {
        user.setRoom(generateNewRoom().toUpperCase());
        return Optional.of(userRepository.save(user));
    }

    @Transactional
    public Optional<User> saveAsMemberOfRoom(User user, String roomToken) {
        boolean isRoomOpen = userRepository.findByRoom(roomToken).isEmpty();
        if (!isRoomOpen) {
            user.setRoom(roomToken.toUpperCase());
            return Optional.of(userRepository.save(user));
        }
        return Optional.empty();
    }

    private String generateNewRoom() {
        return UUID.randomUUID().toString().substring(0, 5);
    }
}
