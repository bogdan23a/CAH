SET database=cardsagainsthumanity;

CREATE TABLE IF NOT EXISTS users
(
    name    VARCHAR NOT NULL,
    room    VARCHAR NOT NULL,
    host    BOOLEAN NOT NULL,
    points  VARCHAR NOT NULL,

    CONSTRAINT pk_users PRIMARY KEY (name)
);

CREATE INDEX IF NOT EXISTS idx_users_name_reference ON users (name);
CREATE INDEX IF NOT EXISTS idx_users_room_reference ON users (room);
CREATE INDEX IF NOT EXISTS idx_users_points_reference On users(points);