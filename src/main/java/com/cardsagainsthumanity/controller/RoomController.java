package com.cardsagainsthumanity.controller;

import com.cardsagainsthumanity.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Put;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;

@Controller("/rooms")
public class RoomController {

    @Inject
    private UserService userService;

    @Get
    public HttpResponse<List<String>> getRooms() {
        return HttpResponse.ok().body(userService.findAllRooms());
    }

    @Put("/{roomToken}")
    public HttpResponse<List<String>> getUsersInRoom(@PathVariable(name = "roomToken") String roomToken) {
        try {
            List<String> room = userService.findUsersInRoom(roomToken);
            if (!room.isEmpty()) {
                return HttpResponse.ok(room);
            }
        } catch (ConstraintViolationException e) {
            return HttpResponse.notAllowed().body(Collections.emptyList());
        }
        return HttpResponse.serverError(Collections.emptyList());
    }
}
