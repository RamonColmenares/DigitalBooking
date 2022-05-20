data "aws_ip_ranges" "us_west_ip_range" {
    regions = ["us-west-1"]
    services = [ "ec2" ]
}


// creo un grupo de seguridad, no olvidarse que hay que cambiar las inbound rules en amazon después para mi IP.

resource "aws_security_group" "sg_us_west" {
    name = "sg_us_west"
    ingress {
        cidr_blocks = data.aws_ip_ranges.us_west_ip_range.cidr_blocks # definir el rango de ip
        from_port = 443
        portocol = "tcp"
        to_port = 443
    }
}

