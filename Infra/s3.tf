/*
resource "aws_s3_bucket" "g1bucket" {
    bucket = "g1bucket-001"
}

*/

resource "aws_s3_bucket" "g1bucket" {

  bucket = "g1bucket-01"


  tags   = {
    Name = "g1bucket-01"
    StackId = "g1bucket"
  }
}

resource "aws_s3_bucket_acl" "g1bucket_bucket_acl" {
  bucket = aws_s3_bucket.g1bucket.id
  acl    = "private"
}


resource "aws_s3_bucket_policy" "s3_policy" {

  bucket = "${aws_s3_bucket.g1bucket.id}"

  policy = <<EOF
{
    "Version": "2012-10-17",
    "Statement": [
            {
            "Sid": "Only allow specific role",
            "Effect": "allow",
            "Principal":"*",
            "Action":  "s3:*",
            "Resource": [
          "arn:aws:s3:::g1bucket-01",
          "arn:aws:s3:::g1bucket-01/*"
            ]

        }
    ]
}
EOF
}


resource "aws_s3_object" "object" {
  bucket = "g1bucket-01"
  key    = "scripts/init.sh"
  source = "scripts/init.sh"
  etag = "${filemd5("scripts/init.sh")}"
}