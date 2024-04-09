resource "aws_db_instance" "postgresql" {
    identifier = "postgresql"
    allocated_storage = 5
    backup_retention_period = 2
    backup_window = "01:00-01:30"
    maintenance_window = "sun:03:00-sun:03:30"
    multi_az = true
    engine = "postgresql" #FIXME
    engine_version = "5.7" #FIXME
    instance_class = "db.t2.micro"
    #name = "minesweeperdb" # FIXME
    db_name = "minesweeperdb"
    username = "minesweeperuser"
    password = "minesweeperpassword"
    port = "5432"
    db_subnet_group_name = aws_db_subnet_group.postgresql-subnet-group.name
    vpc_security_group_ids = [aws_security_group.ecs_sg.id, aws_security_group.ecs_sg.id]
    skip_final_snapshot = true
    final_snapshot_identifier = "worker-final"
    publicly_accessible = true
}