output "postgresql_endpoint" {
    value = aws_db_instance.postgresql.endpoint
}

output "ecr_repository_worker_endpoint" {
    value = aws_ecr_repository.worker.registry_url
}