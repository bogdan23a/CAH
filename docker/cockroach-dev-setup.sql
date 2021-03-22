CREATE USER IF NOT EXISTS dev;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS flyway_schema_history;
DROP DATABASE IF EXISTS cardsagainsthumanity;
CREATE DATABASE IF NOT EXISTS cardsagainsthumanity;
GRANT ALL ON DATABASE cardsagainsthumanity TO dev;
