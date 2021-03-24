package com.cardsagainsthumanity.controller;

import com.fizzed.rocker.Rocker;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import static io.micronaut.http.HttpResponse.ok;
import static io.micronaut.http.MediaType.TEXT_HTML;

@Controller()
public class ViewsController {

    @Get("/home")
    @Produces(TEXT_HTML)
    public HttpResponse<?> index() {
        return ok(Rocker.template("templates/index.rocker.html")
                .bind("message", "mate")
                .render());
    }
}
