package com.cardsagainsthumanity.service;

import io.micronaut.context.annotation.Value;

import javax.inject.Singleton;

@Singleton
public class UserQueryService {

    private String selectAllQuery;
    private String insertUserQuery;
    private String selectUsersForTokenQuery;

    public UserQueryService(@Value("${user.query.service.select.all}") String selectAllQuery,
                            @Value("${user.query.service.insert.user}") String insertUserQuery,
                            @Value("${user.query.service.select.users.for.room.token") String selectUsersForTokenQuery) {
        this.selectAllQuery = selectAllQuery;
        this.insertUserQuery = insertUserQuery;
        this.selectUsersForTokenQuery = selectUsersForTokenQuery;
    }

    public String selectAll() {
        return selectAllQuery;
    }

    public String selectUsersForTokenQuery() {
        return selectUsersForTokenQuery;
    }

    public String insertUserQuery() {
        return insertUserQuery;
    }
}
