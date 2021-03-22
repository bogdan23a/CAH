SET database=cardsagainsthumanity;

CREATE TABLE users(
name STRING PRIMARY KEY,
room_token STRING,
room_leader BOOLEAN NOT NULL);