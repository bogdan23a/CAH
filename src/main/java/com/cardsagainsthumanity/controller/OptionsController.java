package com.cardsagainsthumanity.controller;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Options;
import io.micronaut.http.annotation.PathVariable;

@Controller
public class OptionsController {

    @Options("{/path:.*}")
    @SuppressWarnings("unused")
    void handleOptions(@Nullable @PathVariable String path) {

    }
}
