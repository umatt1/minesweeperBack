# https://stackoverflow.com/questions/74508452/migrate-from-template-file-to-templatefile

data "template_file" "task-definition_template" {
    template = file("task_definition.json.tpl")
    vars = {
        REPOSITORY_URL = replace(aws_ecr_repository.worker.repository_url, "https://", "")
    }
}