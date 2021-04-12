provider "aws" {
    profile = "default"
    region = "eu-west-1"
}

resource "aws_s3_bucket" "cardsagainsthumanity" {
    bucket = "terraform-cardsagainsthumanity-gherasimb"
    acl = "private"
}
