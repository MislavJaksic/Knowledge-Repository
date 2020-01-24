#!/bin/bash

CONFIG_FILE=File-Name.ovpn
USERNAME_PASSWORD_FILE=Username-Password-File.txt

sudo openvpn --config $CONFIG_FILE --auth-user-pass $PASSWORD_USERNAME_FILE
