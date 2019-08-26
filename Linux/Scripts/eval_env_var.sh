#!/bin/bash

# Set local env var
source "/path/to/Script-Name.sh"

# Replace placeholder names with env var values
eval "echo \"$(cat /path/to/File-With-Placeholders.ext)\"" > /path/to/File-With-Replaced-Values.ext
