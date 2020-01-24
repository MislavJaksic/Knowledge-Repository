#!/bin/bash

USERNAME=Username
IP=Ip
PRIVATE_KEY=Private-Key-File.key

sudo ssh -i $PRIVATE_KEY $USERNAME@$IP
