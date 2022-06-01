resource "aws_db_subnet_group" "g1database-subnet-group" {
  name         = "g1database-subnet-group"
  subnet_ids   = [aws_subnet.g1vpc-private-1.id, aws_subnet.g1vpc-private-2.id]
  description  = "Subnet for Group 1's Database instance"

  tags   = {
    Name =  "g1database-subnet"
  }
}

data "aws_db_snapshot" "g1database-snapshot-latest" {
  db_snapshot_identifier = var.DATABASE-SNAPSHOT-IDENTIFIER
  most_recent            = true
  snapshot_type          = "manual"
}

resource "aws_db_instance" "g1database-instance" {
  instance_class          = var.DATABASE-INSTANCE-CLASS
  skip_final_snapshot     = true
  availability_zone       = "us-east-1c"
  identifier              = var.DATABASE-INSTANCE-IDENTIFIER
  snapshot_identifier     = data.aws_db_snapshot.g1database-snapshot-latest.id
  db_subnet_group_name    = aws_db_subnet_group.g1database-subnet-group.name
  multi_az                = var.DATABASE-MAZ-DEPLOYMENT
  vpc_security_group_ids  = [aws_security_group.validate-g1database.id]
}