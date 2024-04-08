provider "aws" {
  region = "us-east-1"  # Change to your desired region
}

resource "aws_ecs_cluster" "my_cluster" {
  name = "my-cluster"
}

resource "aws_ecr_repository" "my_repo" {
  name = "my-repo"
}

# Define IAM roles and policies as needed

data "aws_ecs_task_definition" "my_task_definition" {
  task_definition = jsonencode({
    family                   = "my-task"
    container_definitions   = <<TASK_DEFINITION
[
  {
    "name": "app",
    "image": "${aws_ecr_repository.my_repo.repository_url}:latest",
    "cpu": 256,
    "memory": 512,
    "environment": [
      {
        "name": "DB_URL",
        "value": "jdbc:postgresql://db:5432/minesweeperdb"
      },
      {
        "name": "DB_USERNAME",
        "value": "minesweeperuser"
      },
      {
        "name": "DB_PASSWORD",
        "value": "minesweeperpassword"
      }
    ],
    "portMappings": [
      {
        "containerPort": 8080,
        "hostPort": 8080
      }
    ]
  }
]
TASK_DEFINITION
})

resource "aws_ecs_service" "my_service" {
  name            = "my-service"
  cluster         = aws_ecs_cluster.my_cluster.id
  task_definition = data.aws_ecs_task_definition.my_task_definition.family

  desired_count = 1  # Adjust as needed
}

# Define security groups and load balancers as needed
