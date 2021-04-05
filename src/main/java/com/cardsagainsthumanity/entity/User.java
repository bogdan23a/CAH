package com.cardsagainsthumanity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "room")
    private String room;
    @Column(name = "host")
    private boolean host;
    @Column(name = "points")
    private int points;

    public User(String name, boolean host) {
        this.name = name;
        this.room = "";
        this.host = host;
        this.points = 0;
    }
}