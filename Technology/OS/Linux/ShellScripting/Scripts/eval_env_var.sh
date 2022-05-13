#!/bin/bash

# Set env var
source "/opt/helper/discover-host.sh"

# Replace placeholder names with env var values
eval "echo \"$(cat /opt/helper/server.properties.template)\"" > /opt/kafka_2.12-2.3.0/config/server.properties
