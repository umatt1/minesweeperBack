This is going to be the backend 

It connects to a DB with schema of puzzles, users, and users' solves of the puzzles

DB is postgres with Flyway migrations, runs in Dockerfile

Run scripts from parent directory
(i.e. from minesweeper)

Scripts to create, destroy postgresDB

./scripts/makeContainer to make
./scripts/stopContainer to stop
./scripts/deleteContainer to delete

TODO:
More testing
Secure password storage
More user details
Leaderboards?
Index puzzles by date
Set up solves table for how users will view their past history as well as an export


[RESOURCES]

https://www.baeldung.com/spring-boot-postgresql-docker
