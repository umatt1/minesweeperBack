CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(15) NOT NULL,
    password VARCHAR(20) NOT NULL
);

CREATE TABLE puzzle (
    id INT PRIMARY KEY AUTO_INCREMENT,
    size INT NOT NULL,
    mines INT NOT NULL,
    -- the layout will be a binary string up to a 25 x 25 puzzle
    -- 1 = mine
    -- 0 = open space
    layout NOT NULL VARBINARY(625)
);

CREATE TABLE solve (
    uid INT FOREIGN KEY REFERENCES user(id),
    pid INT FOREIGN KEY REFERENCES puzzle(id),
    time TIME,
    PRIMARY KEY (uid, pid)
);