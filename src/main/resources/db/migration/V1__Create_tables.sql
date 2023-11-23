CREATE TABLE player (
    id SERIAL PRIMARY KEY,
    username VARCHAR(15) NOT NULL,
    password VARCHAR(20) NOT NULL
);

CREATE TABLE puzzle (
    id SERIAL PRIMARY KEY,
    size INT NOT NULL,
    mines INT NOT NULL,
    -- the layout will be a binary string up to a 25 x 25 puzzle
    -- 1 = mine
    -- 0 = open space
    layout INT[25][25] NOT NULL
);

CREATE TABLE solve (
    uid INT,
    pid INT,
    time TIME,
    PRIMARY KEY (uid, pid),
    FOREIGN KEY (uid) REFERENCES player (id) ON DELETE CASCADE,
    FOREIGN KEY (pid) REFERENCES puzzle (id) ON DELETE CASCADE
);