terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 4.16"
    }
  }

  required_version = ">= 1.2.0"
}

provider "aws" {
  region = "us-east-1"
}

# Create a security group allowing SSH access to the EC2 instance
resource "aws_security_group" "ec2_sg" {
  name        = "ec2_sg"
  description = "Security group for EC2 instance"
  
  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

# Create an EC2 instance for the Spring Boot application
resource "aws_instance" "ec2_instance" {
  ami           = "ami-0c55b159cbfafe1f0" # Specify your desired AMI
  instance_type = "t2.micro"
  key_name      = "your_key_pair_name"
  security_groups = [aws_security_group.ec2_sg.name]

  tags = {
    Name = "spring-boot-instance"
  }
}

# Create an RDS instance running PostgreSQL
resource "aws_db_instance" "rds_instance" {
  identifier            = "minesweeperdb"
  allocated_storage     = 20
  storage_type          = "gp2"
  engine                = "postgres"
  engine_version        = "12.5"
  instance_class        = "db.t2.micro"
  db_name               = "minesweeperdb"
  username              = "minesweeperuser"
  password              = "minesweeperpassword"
  parameter_group_name  = "default.postgres12"
  publicly_accessible   = false

  tags = {
    Name = "postgres-rds-instance"
  }
}
