import sys
import os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

# Adds "src" to sys.path
# "src" contains a package "big_package"
# From now on, you can do an import with "from big_package.Sub-Package ..."