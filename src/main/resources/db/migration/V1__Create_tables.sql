CREATE TABLE player (
    id SERIAL PRIMARY KEY,
    username VARCHAR(15) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
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
    uid INT,
    pid INT,
    time TIME,
    PRIMARY KEY (uid, pid),
    FOREIGN KEY (uid) REFERENCES player (id) ON DELETE CASCADE,
    FOREIGN KEY (pid) REFERENCES puzzle (id) ON DELETE CASCADE
);