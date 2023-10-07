-- Insert data into the 'user' table
INSERT INTO user (username, password) VALUES
('user1', 'password1'),
('user2', 'password2'),
('user3', 'password3');

-- Insert data into the 'puzzle' table
INSERT INTO puzzle (size, mines, layout) VALUES
(8, 10, X'FFFFFFFFFFFFFFFFFFFFFFFFF'), -- A layout with no mines
(10, 20, X'FFFFFFFFFFFFFFFFFFF0000F'), -- A layout with some mines

-- Insert data into the 'solve' table
INSERT INTO solve (uid, pid, time) VALUES
(1, 1, '00:15:30'),
(2, 2, '00:22:45');
