resource "aws_ecs_task_definition" "task_definition" {
  family = "worker"
  container_definitions = data.template_file.task-definition_template.rendered
}