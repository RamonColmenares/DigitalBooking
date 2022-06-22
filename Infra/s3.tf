resource "aws_s3_bucket" "g1bucket" {

  bucket = "g1bucket-01"
  force_destroy = true


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
/*


resource "aws_s3_object" "script1" {
  bucket = "g1bucket-01"
  key    = "scripts/init1.sh"
  source = "scripts/init1.sh"
  etag = "${filemd5("scripts/init1.sh")}"
}

resource "aws_s3_object" "script2" {
  bucket = "g1bucket-01"
  key    = "scripts/init3.sh"
  source = "scripts/init3.sh"
  etag = "${filemd5("scripts/init3.sh")}"
}

*/

resource "aws_s3_object" "imgs" {
  for_each = fileset("/img/", "*")

  bucket = "g1bucket-01"
  key    = "img/${each.value}"
  source = "img/${each.value}"
  etag   = filemd5("img/${each.value}")
}

