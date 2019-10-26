#!/bin/bash

CONTAINER_IP=$(ip route show default | awk '/default/ {print $3}')

export CONTAINER_IP="$CONTAINER_IP"
