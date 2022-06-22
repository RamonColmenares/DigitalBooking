data "template_file" "script1" {
    template = "${file("${path.module}/scripts/init1.sh")}"
}

data "template_file" "script3" {
    template = "${file("${path.module}/scripts/init3.sh")}"
}

data "aws_availability_zones" "available" {}

// según la documentación de amazon, el siguiente bloque de data es así para la imagen de ubuntu server

data "aws_ami" "ubuntu" {
    most_recent = true
    owners = ["099720109477"]
    filter {
        name = "name"
        values = ["ubuntu/images/hvm-ssd/ubuntu-focal-20.04-amd64-server-*"]
    }
}

resource "aws_key_pair" "mykey" {
    key_name = "mykey"
    public_key = file(var.PATH_TO_PUBLIC_KEY)
}

resource "aws_instance" "instance1" {
    ami = data.aws_ami.ubuntu.id
    instance_type = "t2.micro"
    availability_zone = data.aws_availability_zones.available.names[2]
    key_name = aws_key_pair.mykey.key_name
    vpc_security_group_ids = [ aws_security_group.validate-g1vpc-ssh.id, aws_security_group.validate-g1vpc-http.id ]
    subnet_id = aws_subnet.g1vpc-public-1.id
    depends_on = [aws_s3_bucket.g1bucket]
    tags = {
        Name = "g1_instance1"
    }

    user_data = "${data.template_file.script1.rendered}"

/*       
    provisioner "remote-exec" {
        inline = [
            "sudo apt-get -y update",
            "sudo apt-get -y install nginx",
            "sudo service nginx start",
        ]
    }

*/

    // según la documentación de terraform, coalesce es una función que devuelve el primer valor que no es nulo.

    connection {
        host = coalesce(self.public_ip, self.private_ip)
        type = "ssh"
        user = var.INSTANCE_USERNAME
        private_key = file(var.PATH_TO_PRIVATE_KEY)
    }
}

resource "aws_instance" "instance2" {
    ami = data.aws_ami.ubuntu.id
    instance_type = "t2.micro"
    availability_zone = data.aws_availability_zones.available.names[3]
    key_name = aws_key_pair.mykey.key_name
    vpc_security_group_ids = [ aws_security_group.validate-g1vpc-ssh.id, aws_security_group.validate-g1vpc-http.id ]
    subnet_id = aws_subnet.g1vpc-public-2.id
    tags = {
        Name = "g1_instance2"
    }
}

resource "aws_instance" "instance3" {
    ami = data.aws_ami.ubuntu.id
    instance_type = "t2.micro"
    availability_zone = data.aws_availability_zones.available.names[2]
    key_name = aws_key_pair.mykey.key_name
    vpc_security_group_ids = [ aws_security_group.validate-g1vpc-ssh.id ]
    subnet_id = aws_subnet.g1vpc-private-1.id
    tags = {
        Name = "g1_instance3"
    }

    user_data = "${data.template_file.script3.rendered}"
    
}

resource "aws_instance" "instance4" {
    ami = data.aws_ami.ubuntu.id
    instance_type = "t2.micro"
    availability_zone = data.aws_availability_zones.available.names[3]
    key_name = aws_key_pair.mykey.key_name
    vpc_security_group_ids = [ aws_security_group.validate-g1vpc-ssh.id ]
    subnet_id = aws_subnet.g1vpc-private-2.id
    tags = {
        Name = "g1_instance4"
    }
}