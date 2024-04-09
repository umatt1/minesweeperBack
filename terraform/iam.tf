data "aws_iam_policy_document" "ecs_agent" {
    statement {
        actions = ["sts:AssumeRole"]

        principals {
          type = "Service"
          identifiers = ["ec2.amazonaws.com"]
        }
    }
}

resource "aws_iam_role" "ecs_agent" {
    name = "ecs-agent"
    assume_role_policy = data.aws_iam_policy_document.ecs_agent.json
}

resource "aws_iam_role_policy_attachment" "ecs_agent" {
  role = "aws_iam_role.ecs_agent"
  policy_arn = "arn:aws:iam::aws:policy/service-role/AmazonEC2ContainerServiceforEC2Role"
  #policy_arn = "asdfasdfasdf" # TODO: GET A POLICY HERE:
  # arn:aws:iam::aws:policy/service-role/AmazonEC2ContainerServiceforEC2Role
}
resource "aws_iam_instance_profile" "ecs_agent" {
  name = "ecs_agent"
  role = aws_iam_role.ecs_agent.name
}