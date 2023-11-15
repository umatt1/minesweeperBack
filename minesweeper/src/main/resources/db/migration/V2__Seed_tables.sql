-- Insert data into the 'player' table
INSERT INTO player (username, password) VALUES
    ('user1', 'password1'),
    ('user2', 'password2'),
    ('user3', 'password3');

-- Insert data into the 'puzzle' table
INSERT INTO puzzle (size, mines, layout) VALUES
    (8, 0, E'\\x' || '0'::bytea), -- A layout with no mines
    (10, 10, E'\\x180040800000000030218200'::bytea); -- A layout with some mines

-- Insert data into the 'solve' table
INSERT INTO solve (uid, pid, time) VALUES
    (1, 1, '00:15:30'),
    (2, 2, '00:22:45');
