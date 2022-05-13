#!/bin/bash

declare -A animals =( ["moo"]="Cow"
                      ["bee"]="Sheep"
                      ["wuf"]="Dog"
                    )

# Iterate over keys                     
for sound in "${!animals[@]}"
  do
  echo ${animals[$sound]}
  done
    