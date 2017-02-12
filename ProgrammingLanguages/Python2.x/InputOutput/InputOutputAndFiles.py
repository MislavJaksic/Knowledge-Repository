import sys

#You can input data throught the command line
for commandLineArgument in sys.argv:
  #sys.argv[0] is always the script name
  print commandLineArgument, #-> InputOutputAndFiles.py <first_command_line_arg> <...>
print
#Ask for user input and display message
print input("Type something in:") #-> what the user inputs
#Define how you will use the file, use it and then close it
file = open("fileName.txt", "rU")
#Read a byte of data
print file.read(1) #-> 'A'; the first char in the file
#Close a file
file.close()

#Output a fancy string
print "This is a {} string in a very well {} format. It has {} paramaters.".format("fancy", "defined", 3)
#-> "This is a fancy string in a very well defined format. It has 3 paramaters."


