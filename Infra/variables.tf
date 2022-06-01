// para más seguridad, agrego variables de entorno en otro archivo.

variable "AWS_ACCESS_KEY" {
    type = string
    default = "mock_access_key"
}

variable "AWS_SECRET_KEY" {
    type = string
    default = "mock_secret_key"
}

variable "AWS_REGION" {
    default = "us-east-1"
}

variable "PATH_TO_PRIVATE_KEY" {
    default = "mykey"
}

variable "PATH_TO_PUBLIC_KEY" {
    default = "mykey.pub"
}

variable "INSTANCE_USERNAME" {
    default = "ubuntu"
}