This is going to be the backend 

It connects to a DB with schema of puzzles, users, and users' solves of the puzzles

DB is postgres with Flyway migrations, runs in Dockerfile

Run scripts from parent directory
(i.e. from minesweeper)

Scripts to create, destroy postgresDB

./scripts/makeContainer to make
./scripts/stopContainer to stop
./scripts/deleteContainer to delete

TODO: MAKE PUZZLE DATE A UNIQUE FIELD??????

[RESOURCES]

https://www.baeldung.com/spring-boot-postgresql-docker
