package com.cardsagainsthumanity.controller;

import com.cardsagainsthumanity.dto.UserDto;
import com.cardsagainsthumanity.repository.UserRepository;
import com.cardsagainsthumanity.transformer.UserTransformer;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

import static io.micronaut.http.HttpResponse.ok;

@Controller("/events")
public class EventsController {
    private static final Logger Log = LoggerFactory.getLogger(EventsController.class);

    @Inject
    private UserRepository userRepository;
    @Inject
    private UserTransformer userTransformer;

    @Get(value = "/{roomToken}", produces = MediaType.TEXT_EVENT_STREAM)
    public HttpResponse<String> keepAliveConnection(@PathVariable(name = "roomToken") String roomToken) {
        List<UserDto> users = userRepository.findByRoom(roomToken).stream().
                map(userTransformer::transform).collect(Collectors.toList());
        return ok()
                .header("Connection", "keep-alive")
                .header("Content-Type", "text/event-stream")
                .header("Cache-Control", "no-cache")
                .header("Access-Control-Allow-Origin", "*")
                .body("data: {\"users\": " +  users + "}\n\n");
    }
}
