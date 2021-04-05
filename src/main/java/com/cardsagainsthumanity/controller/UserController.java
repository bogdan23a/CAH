package com.cardsagainsthumanity.controller;

import com.cardsagainsthumanity.entity.User;
import com.cardsagainsthumanity.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Put;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.Optional;

import static io.micronaut.http.HttpResponse.notAllowed;
import static io.micronaut.http.HttpResponse.ok;
import static io.micronaut.http.HttpResponse.serverError;

@Controller("/users")
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Inject
    private UserService userService;

    @Get
    public Collection<User> getAllUsers() {
        return userService.findAll();
    }

    @Get("/{roomToken}")
    public Collection<User> getUsersInRoom(@PathVariable(name = "roomToken") String roomToken) {
        return userService.findAllInRoom(roomToken);
    }

    @Put("/host/{name}")
    public HttpResponse<Optional<User>> save(@PathVariable(name = "name") String name) {
        try {
            if (!name.isBlank()) {
                return ok().body(userService.saveNewHost(name));
            }
        } catch (ConstraintViolationException e) {
            LOG.warn("User {} violates DB constrains. ", name);
            return notAllowed().body(Optional.empty());
        }
        return serverError().body(Optional.empty());
    }

    @Put("/member/{name}/{roomToken}")
    public HttpResponse<Optional<User>> save(@PathVariable(name = "name") String name,
                                             @PathVariable(name = "roomToken") String roomToken) {
        try {
            if (!name.isBlank() && !roomToken.isBlank()) {
                return ok().body(userService.saveNewMember(name, roomToken));
            }
        } catch (Exception e) {
            LOG.warn("User {} violates DB constrains. ", name);
            return notAllowed().body(Optional.empty());
        }
        return serverError().body(Optional.empty());
    }
}
