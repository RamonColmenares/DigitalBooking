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

variable "DATABASE-SNAPSHOT-IDENTIFIER" {
    default = "arn:aws:rds:us-east-1:145504712931:snapshot:g1-database-snapshot"
    description = "Database Snapshot ARN"
    type = string
}

variable "DATABASE-INSTANCE-CLASS" {
    default = "db.t2.micro"
    description = "Database instance type"
    type = string
}

variable "DATABASE-INSTANCE-IDENTIFIER" {
    default = "g1database"
    description = "Database instance identifier"
    type = string
}

variable "DATABASE-MAZ-DEPLOYMENT" {
    default = "false"
    description = "Create a Standby DB Instance"
    type = bool
}