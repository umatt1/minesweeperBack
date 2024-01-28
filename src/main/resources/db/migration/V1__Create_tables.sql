CREATE TABLE player (
    username VARCHAR(15) NOT NULL UNIQUE,
    email VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT true
);

CREATE TABLE authority (
    email VARCHAR(255) PRIMARY KEY,
    authority VARCHAR(255) NOT NULL,
    FOREIGN KEY (email) REFERENCES player(email)
);

CREATE TABLE puzzle (
    id SERIAL PRIMARY KEY,
    width INT NOT NULL,
    height INT NOT NULL,
    layout INT[] NOT NULL,
    date DATE UNIQUE,
    CONSTRAINT layout_size_constraint CHECK (array_length(layout, 1) = width * height)
);

CREATE TABLE solve (
    username VARCHAR(15),
    pid INT,
    time TIME,
    PRIMARY KEY (username, pid),
    FOREIGN KEY (username) REFERENCES player (username) ON DELETE CASCADE,
    FOREIGN KEY (pid) REFERENCES puzzle (id) ON DELETE CASCADE
);