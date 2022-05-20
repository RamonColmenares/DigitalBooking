

data "aws_availability_zones" "available" {}

// según la documentación de amazon, el siguiente bloque de data es así para la imagen de ubuntu server

data "aws_ami" "ubuntu" {
    most_recent = true
    owners = ["099720109477"]
    filter {
        name = "name"
        values = ["ubuntu/images/hvm-ssd/ubuntu-xenial-22.17-amd64-server-*"]
    }
}

resource "aws_key_pair" "mykey" {
    key_name = "mykey"
    public_key = file(var.PATH_TO_PUBLIC_KEY)
}

resource "aws_instance" "boceto" {
    count = 4
    ami = data.aws_ami.ubuntu.id
    instance_type = "t2.micro"
    availability_zone = data.aws_availability_zones.available.names[0]
    tags = {
        Name = "instance-${count.index}"
    }

    // según la documentación de terraform, provisioner copia los scripts a mi instancia y las ejecuta.
    // ejecuto el script que instala Nginx tras la configuración inline de los permisos.

    provisioner "file" {
    source = "installNginx.sh"
    destination = "/tmp/installNginx.sh"
    }

    provisioner "remote-exec" {
        inline = [
            "chmod +x /tmp/instalNginx.sh",
            "sudo /tmp/installNginx.sh",
        ]
    }

    // según la documentación de terraform, coalesce es una función que devuelve el primer valor que no es nulo.

    connection {
        host = coalesce(self.public_ip, self.private_ip)
        type = "ssh"
        user = var.INSTANCE_USERNAME
        private_key = file(var.PATH_TO_PRIVATE_KEY)
    }
}
output "public_ip" {
    value = aws_instance.boceto.public_ip
}

