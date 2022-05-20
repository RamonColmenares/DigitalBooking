// para más seguridad, agrego variables de entorno en otro archivo.

variable "AWS_ACCESS_KEY" {
    type = string
    default = "XXXXXXX"
}

variable "AWS_SECRET_KEY" {
    type = string
    default = "xxxxxxxxxXXXXXXxx"
}

variable "AWS_REGION" {
    type = string
    default = "us-west-1"
}

VARIABLE "PATH_TO_PUBLIC_KEY" {
    default = "mykey.pub"
}

variable "INSTANCE_USERNAME" {
    default = "ubuntu"
}