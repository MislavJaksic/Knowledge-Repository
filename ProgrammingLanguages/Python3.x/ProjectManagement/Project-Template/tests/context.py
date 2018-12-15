import sys
import os
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '..', "src")))

#Add "src" to sys.path -> "src" contains a package "big_package"
#From now on, you can do an import like "from big_package. ..."