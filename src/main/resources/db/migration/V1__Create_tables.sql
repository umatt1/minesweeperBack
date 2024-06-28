-- Role Table
CREATE TABLE roles (
    role_id SERIAL PRIMARY KEY,
    authority VARCHAR(255) NOT NULL
);

-- User Table
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
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
    pid INTEGER REFERENCES puzzle(id),
    time TIME,
    success BOOLEAN NOT NULL,
    PRIMARY KEY (username, pid)
);

-- User-Role Junction Table
CREATE TABLE user_role_junction (
    user_id INTEGER REFERENCES users(user_id),
    role_id INTEGER REFERENCES roles(role_id),
    PRIMARY KEY (user_id, role_id)
);

-- Create the friend_request table
CREATE TABLE friend_request (
    requester VARCHAR(255) REFERENCES users(username),
    requested VARCHAR(255) REFERENCES users(username),
    status VARCHAR(20) DEFAULT 'pending',
    CHECK (status IN ('pending', 'accepted')),
    PRIMARY KEY (requester, requested)
);

-- Create the function to check for duplicates
CREATE OR REPLACE FUNCTION check_unique_friend_request() RETURNS trigger AS $$
BEGIN
    IF EXISTS (SELECT 1 FROM friend_request
               WHERE (requester = LEAST(NEW.requester, NEW.requested)
                  AND requested = GREATEST(NEW.requester, NEW.requested))) THEN
        RAISE EXCEPTION 'Duplicate friend request';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Create the trigger that calls the function before inserting a new row
CREATE TRIGGER unique_friend_request_trigger
BEFORE INSERT ON friend_request
FOR EACH ROW
EXECUTE FUNCTION check_unique_friend_request();
