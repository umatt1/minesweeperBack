CREATE TABLE player (
    id SERIAL PRIMARY KEY,
    username VARCHAR(15) NOT NULL,
    password VARCHAR(20) NOT NULL
);

CREATE TABLE puzzle (
    id SERIAL PRIMARY KEY,
    layout INT[25][25] NOT NULL,
    -- date is used only if it is a puzzle of the day
    date DATE
);

CREATE TABLE solve (
    uid INT,
    pid INT,
    time TIME,
    PRIMARY KEY (uid, pid),
    FOREIGN KEY (uid) REFERENCES player (id) ON DELETE CASCADE,
    FOREIGN KEY (pid) REFERENCES puzzle (id) ON DELETE CASCADE
);