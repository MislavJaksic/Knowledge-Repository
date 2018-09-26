import sys
import os
#Allows the importation of parent moduels
print sys.path #-> lists all folders where it will search for modules
print os.path.abspath('..') #-> ...\TopLevel\SubLevelOne
sys.path.insert(0, os.path.abspath('../..')) #-> add TopLevel to the sys.path

from SubLevelOne import SubLevelOneModule #Works!
#from TopLevel.SubLevelOne import SubLevelOneModule #Doesen't work!

SubLevelOneModule.EchoSLO() #-> SLO
print SubLevelOneModule.SLO_CONSTANT #-> You can import a constant from SLO

from SubLevelTwo import SubLevelTwoModule #Works!

SubLevelTwoModule.EchoSLT() #-> SLT