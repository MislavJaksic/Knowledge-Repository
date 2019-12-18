#!/bin/bash

KUBECTL_SERVER_IP=

TLS_SOURCE_PATH=/etc/docker/certs.d
TLS_SINK_PATH=/home/centos
TLS_DIR_NAME=$KUBECTL_SERVER_IP:30003

REMOTE_USER=centos

for REMOTE_MACHINE in x y z
  do
  sudo scp -i ansible.key -r $TLS_SOURCE_PATH/$TLS_DIR_NAME $REMOTE_USER@$REMOTE_MACHINE:$TLS_SINK_PATH
  sudo ssh -i ansible.key $REMOTE_USER@$REMOTE_MACHINE "sudo mkdir -p $TLS_SOURCE_PATH"
  sudo ssh -i ansible.key $REMOTE_USER@$REMOTE_MACHINE "sudo cp -r $TLS_DIR_NAME $TLS_SOURCE_PATH/$TLS_DIR_NAME"
done
