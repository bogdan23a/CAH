package com.cardsagainsthumanity.service;

import com.cardsagainsthumanity.entity.User;
import com.cardsagainsthumanity.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class TransactionalUserService {

    @Inject
    private UserRepository userRepository;

    public TransactionalUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User update(User user) {
        return null;
    }
}
