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



/*
data "aws_ip_ranges" "us_east_ip_range" {
    regions = ["us-east-1"]
    services = [ "ec2" ]
}


// creo un grupo de seguridad, no olvidarse que hay que cambiar las inbound rules en amazon después para mi IP.

resource "aws_security_group" "g1_sg_us_east" {
    name = "g1_sg_us_east"
    ingress {
        cidr_blocks = data.aws_ip_ranges.us_east_ip_range.cidr_blocks # definir el rango de ip
        from_port = 443
        protocol = "tcp"
        to_port = 443
    }
}

*/