package com.cardsagainsthumanity.service;

import com.cardsagainsthumanity.controller.EventsController;
import com.cardsagainsthumanity.entity.User;
import com.cardsagainsthumanity.repository.UserRepository;
import net.bytebuddy.implementation.bytecode.collection.CollectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.events.Event;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Singleton
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Inject
    private UserRepository userRepository;
    @Inject
    private TransactionalUserService transactionalUserService;
    @Inject
    private EventsController eventsController;

    public UserService(UserRepository userRepository,
                       EventsController eventsController,
                       TransactionalUserService transactionalUserService) {
        this.userRepository = userRepository;
        this.eventsController = eventsController;
        this.transactionalUserService = transactionalUserService;
    }

    public List<User> findAll() {
        return StreamSupport.stream(
                        userRepository.findAll().spliterator(), true)
                        .collect(Collectors.toList());
    }

    public List<String> findAllRooms() {
        return findAll().stream()
                .map(User::getRoom)
                .collect(Collectors.toList());
    }

    public List<String> findUsersInRoom(String roomToken) {
        return userRepository.findByRoom(roomToken)
                .stream().map(User::getName)
                .collect(Collectors.toList());
    }

    public Collection<User> findAllInRoom(String roomToken) {
        return userRepository.findByRoom(roomToken);
    }

    public Optional<User> saveNewHost(String userName) {
        if (!userName.isBlank()) {
            return transactionalUserService.saveAsHost(new User(userName, true));
        }
        return Optional.empty();
    }

    public Optional<User> saveNewMember(String userName, String roomToken) {
        if (!userName.isBlank() && !roomToken.isBlank()) {
            Optional<User> optionalUser = transactionalUserService.saveAsMemberOfRoom(new User(userName, false), roomToken);
            return optionalUser;
        }
        return Optional.empty();
    }
}
