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
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "room_token")
    private String roomToken;
    @Column(name = "room_leader")
    private boolean roomLeader;

}