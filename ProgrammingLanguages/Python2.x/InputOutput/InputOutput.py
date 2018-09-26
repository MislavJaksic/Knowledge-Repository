import sys

#You can input data throught the command line
for commandLineArgument in sys.argv:
  #sys.argv[0] is always the script name
  print commandLineArgument, #-> InputOutputAndFiles.py <first_command_line_arg> <second_...>
print
#Ask for user input and display message
print raw_input("Type something in:") #-> what the user inputs

#Define how you will use the file
file = open("fileName.txt", "rU")
#Read a byte of data
print file.read(1) #-> 'A'; the first char in the file
#Close a file
file.close()
#OR
with open("fileName.txt", "rU") as file:
  print file.read(1)

#Destroy an existing file and create a new empty file
file = open("fileName.txt", "w")
#Write at the end of a file
file.write("ABCD")
file.close()

#Output a fancy string
print "This is a {} string in a well {} format. It has {} paramaters.".format("fancy", "defined", 3)
#-> "This is a fancy string in a well defined format. It has 3 paramaters."
