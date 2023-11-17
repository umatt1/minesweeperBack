This is going to be the backend 

It connects to a DB with schema of puzzles, users, and users' solves of the puzzles

DB will be postgres with Flyway migrations

All will run as a single docker container

Run all of the scripts from this directory
(i.e. from minesweeper)

./scripts/makeContainer to make
./scripts/stopContainer to stop
./scripts/deleteContainer to delete

todo: create a single script that can perform this stuff and ensure correct directory

todo: get flyway migrations to work correctly

todo: flush out the actual back end, right now does not have api endpoints and probably is broken

[RESOURCES]

https://www.baeldung.com/spring-boot-postgresql-docker