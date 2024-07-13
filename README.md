This is the backend for Sweeple

It connects to a DB with schema of puzzles, users, and users' solves of the puzzles
DB_PASSWORD=minesweeperpassword;DB_URL=jdbc:postgresql://localhost:5432/postgres;DB_USERNAME=minesweeperuser

DB is postgres with Flyway migrations, runs in Dockerfile

Run scripts from parent directory
(i.e. from minesweeper)

Scripts to create, destroy postgresDB

./scripts/makeContainer to make
./scripts/stopContainer to stop
./scripts/deleteContainer to delete

Notes for testing

http://localhost:8080/api/v1/actuator/health

http://localhost:8080/api/v1/auth/login

{
"username": "123",
"password": "."
}



[RESOURCES]

https://www.baeldung.com/spring-boot-postgresql-docker
https://www.bezkoder.com/spring-boot-react-jwt-auth/
https://www.youtube.com/watch?v=TeBt0Ike_Tk
https://www.youtube.com/watch?v=GowFk_5Rx_I
https://github.com/ruanbekker/aws-terraform-cicd-java-springboot
https://github.com/timurgaleev/ecs-spring-boot-rds-tf/tree/master
https://medium.com/warp9/get-started-with-aws-ecs-cluster-using-terraform-cfba531f7748
https://github.com/aws-samples/aws-ecs-cicd-terraform/blob/master/terraform/ecs-fargate.tf
