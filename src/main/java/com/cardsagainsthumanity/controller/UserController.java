package com.cardsagainsthumanity.controller;

import com.cardsagainsthumanity.entity.User;
import com.cardsagainsthumanity.service.UserService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.RequestAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.Optional;

@Controller("/users")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Inject
    private UserService userService;

    @Get
    public Collection<User> getAllUsers() {
        return userService.findAll();
    }

    @Put("/{name}")
    public Optional<User> save(@RequestAttribute("name") Optional<String> name) {
        try {
            LOG.debug("Saved user {}", name);
            if (name.isPresent()) {
                return userService.save(name.get());
            }
        } catch (ConstraintViolationException e) {
            LOG.warn("User {} violates DB constrains. ", name);
        }
        return Optional.empty();
    }
}
