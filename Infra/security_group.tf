resource "aws_security_group" "validate-g1vpc-ssh" {
    vpc_id = aws_vpc.g1vpc.id
    name = "validate-g1vpc-ssh"
    description = "Security Group by Group 1 to validate ssh connection"
    
    ingress {
        from_port = 22
        to_port = 22
        protocol = "tcp"
        cidr_blocks = ["0.0.0.0/0"]
    }

    egress {
        from_port = 0
        to_port = 0
        protocol = "-1"
        cidr_blocks = ["0.0.0.0/0"]
        }
        tags = {
            Name = "validate-g1vpc-ssh"
        }
}

resource "aws_security_group" "validate-g1vpc-http" {
    vpc_id = aws_vpc.g1vpc.id
    name = "validate-g1vpc-http"
    description = "Security Group by Group 1 to validate http connection"
    
    ingress {
        from_port = 80
        to_port = 80
        protocol = "tcp"
        cidr_blocks = ["0.0.0.0/0"]
    }

    egress {
        from_port = 0
        to_port = 0
        protocol = "-1"
        cidr_blocks = ["0.0.0.0/0"]
        }
        tags = {
            Name = "validate-g1vpc-http"
        }
}

resource "aws_security_group" "validate-g1database" {
    vpc_id = aws_vpc.g1vpc.id
    name = "validate-g1database"
    description = "Security Group by Group 1 to validate database connection"
    
    ingress {
        description = "MYSQL Access"
        from_port = 3306
        to_port = 3306
        protocol = "tcp"
        cidr_blocks = ["0.0.0.0/0"]
    }

    egress {
        from_port = 0
        to_port = 0
        protocol = "-1"
        cidr_blocks = ["0.0.0.0/0"]
        }
        tags = {
            Name = "validate-g1database"
        }
}