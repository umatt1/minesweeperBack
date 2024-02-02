-- Role Table
CREATE SEQUENCE roles_seq;
CREATE TABLE roles (
    role_id SERIAL PRIMARY KEY,
    authority VARCHAR(255) NOT NULL
);

-- User Table
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    CONSTRAINT username_unique UNIQUE (username)
);

-- Puzzle Table
CREATE TABLE puzzle (
    id SERIAL PRIMARY KEY,
    date DATE UNIQUE,
    layout INTEGER ARRAY NOT NULL,
    height BIGINT NOT NULL,
    width BIGINT NOT NULL
);

-- Solve Table
CREATE TABLE solve (
    username VARCHAR(255) REFERENCES users(username),
    pid BIGINT REFERENCES puzzle(id),
    time TIME,
    PRIMARY KEY (username, pid)
);

-- User-Role Junction Table
CREATE TABLE user_role_junction (
    user_id INTEGER REFERENCES users(user_id),
    role_id INTEGER REFERENCES roles(role_id),
    PRIMARY KEY (user_id, role_id)
);
