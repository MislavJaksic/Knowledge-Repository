def BeginFunc():
  #Two spaces are used as indents; there are no curly brackets
  
  outsideVar = 5
  
  #A function cannot change an outside variable
  #because you cannot pass it as a reference
  print SquareVar(outsideVar) #-> 25
  print outsideVar #-> 5
  
  #A simple recursive function
  outsideString = "abdcba"
  print CheckPalindrome(outsideString) #-> "No"
  #Call with a keyword argument
  print CheckPalindrome(string="nonnon") #-> "Yes"
  
  #Store a function as if it were a value
  storeFunction = CheckPalindrome
  #Call a function with positional arguments
  print storeFunction("abba", 1, "Variable", "arguments") #-> "Yes"
  
def SquareVar(inputVar):
  inputVar = inputVar*inputVar
  return inputVar
  
def CheckPalindrome(string, checkPosition=0, *manyArgs):
  """Default argument checkPosition. It is evaluated only once.
      If it was a list, it would accumulate data in subsequent calls.
      Variable number of arguments are stored in *manyArgs.
  """
  if manyArgs is not ():
    print manyArgs #-> ("Variable", "arguments")
  stringLength = len(string)
  if stringLength % 2 == 1:
    return "No"
  if stringLength/2 < checkPosition:
    return "Yes"
  if string[checkPosition] == string[stringLength - checkPosition - 1]:
    return CheckPalindrome(string, checkPosition + 1)
  else:
	return "No"

#Tell the program where to begin
#Must be at the bottom of the program
if __name__ == '__main__':
  BeginFunc()

#Equal to writing:

#BeginFunc()