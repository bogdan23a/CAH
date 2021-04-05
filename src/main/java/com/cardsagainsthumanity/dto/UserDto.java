package com.cardsagainsthumanity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String name;
    private boolean host;
    private int points;

    @Override
    public String toString() {
        return "{\"name\":\"" + name + "\"," +
                "\"host\":\"" + host + "\"," +
                "\"points\":\"" + points + "\"}";

    }
}
