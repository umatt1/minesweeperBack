resource "aws_db_subnet_group" "postgresql-subnet-group" {
    name = "postgresql-subnet-group"
    subnet_ids = [aws_subnet.pub_subnet.id, aws_subnet.pub2_subnet.id]
}