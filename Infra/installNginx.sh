#!/bin/bash
# duerme hasta que la instancia esté lista.
until [[ -f /var/lib/cloud/instance/boot-finished ]]; do
  sleep 1
done

# instalo nginx
apt-get update
apt-get -y install nginx
service nginx start