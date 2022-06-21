resource "aws_db_subnet_group" "g1database-Master-subnet-group" {
  name         = "g1database-master-subnet-group"
  subnet_ids   = [aws_subnet.g1vpc-private-1.id, aws_subnet.g1vpc-private-2.id]
  description  = "Subnet for Group 1's Database Master instance"

  tags   = {
    Name =  "g1database-Master-subnet"
  }
}

resource "aws_db_subnet_group" "g1database-Replica-subnet-group" {
  name         = "g1database-replica-subnet-group"
  subnet_ids   = [aws_subnet.g1vpc-private-1.id, aws_subnet.g1vpc-private-2.id]
  description  = "Subnet for Group 1's Database Replica instance"

  tags   = {
    Name =  "g1database-Replica-subnet"
  }
}

data "aws_db_snapshot" "g1database-snapshot-latest" {
  db_snapshot_identifier = var.DATABASE-SNAPSHOT-IDENTIFIER
  most_recent            = true
  snapshot_type          = "manual"
}

resource "aws_db_instance" "g1database-Master-instance" {
  instance_class          = var.DATABASE-INSTANCE-CLASS
  username                = "admin"
  password                = "password"
  skip_final_snapshot     = true
  availability_zone       = "us-east-1c"
  identifier              = var.DATABASE-INSTANCE-IDENTIFIER1
  snapshot_identifier     = data.aws_db_snapshot.g1database-snapshot-latest.id
  db_subnet_group_name    = aws_db_subnet_group.g1database-Master-subnet-group.name
  multi_az                = var.DATABASE-MAZ-DEPLOYMENT
  vpc_security_group_ids  = [aws_security_group.validate-g1database.id]
  publicly_accessible     = true
}

resource "aws_db_instance" "g1database-Replica-instance" {
  instance_class          = var.DATABASE-INSTANCE-CLASS
  skip_final_snapshot     = true
  availability_zone       = "us-east-1d"
  identifier              = var.DATABASE-INSTANCE-IDENTIFIER2
  snapshot_identifier     = data.aws_db_snapshot.g1database-snapshot-latest.id
  db_subnet_group_name    = aws_db_subnet_group.g1database-Replica-subnet-group.name
  multi_az                = var.DATABASE-MAZ-DEPLOYMENT
  vpc_security_group_ids  = [aws_security_group.validate-g1database.id]
  publicly_accessible     = true
}