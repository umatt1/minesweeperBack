# https://stackoverflow.com/questions/74508452/migrate-from-template-file-to-templatefile

locals {
    task_definition_template = templatefile("task_definition.json.tpl", {
        REPOSITORY_URL = replace(aws_ecr_repository.worker.repository_url, "https://", "")
    })
}

