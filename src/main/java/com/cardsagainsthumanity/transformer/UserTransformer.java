package com.cardsagainsthumanity.transformer;

import com.cardsagainsthumanity.dto.UserDto;
import com.cardsagainsthumanity.entity.User;

import javax.inject.Singleton;

@Singleton
public class UserTransformer {

    public UserDto transform(User user) {
        return new UserDto(user.getName(),
                            user.isHost(),
                            user.getPoints());
    }
}
