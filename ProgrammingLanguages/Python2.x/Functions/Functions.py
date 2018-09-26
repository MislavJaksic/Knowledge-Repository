def BeginFunc():
  outsideArray = [0, 1, 2]
  
  ChangePointer(outsideArray)
  print outsideArray #-> [0, 1, 2]; no change
  
  ChangeArray(outsideArray)
  print outsideArray #-> [0, 1, 2, 3]; array passed by reference
  
  outsideString = "abdcba"
  print CheckPalindrome(outsideString) #-> "No"
  #Call with a keyword argument
  print CheckPalindrome(string="nonnon") #-> "Yes"
  
  #Store a function as if it were a value
  storeFunction = CheckPalindrome
  #Call a function with positional arguments
  print storeFunction("abba", 1, "Other", "arguments") #-> "Yes"
  
def ChangePointer(inputArray):
  inputArray = [0, 1, 2, 3]

def ChangeArray(inputArray):
  inputArray.append(3)
  return 1, 2 #-> can return multiple values
  
def CheckPalindrome(string, checkPosition=0, *manyArgs):
  """Default argument checkPosition. It is evaluated only once.
      If it was a list, it would accumulate data in subsequent calls.
      Variable number of arguments are stored in *manyArgs.
  """
  if manyArgs is not ():
    print manyArgs #-> ("Other", "arguments")
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
