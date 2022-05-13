## Shell Scripting

Bash is a command line language. The name stands for Bourne Again SHell.  

### Syntax

```
#!/usr/bin/env bash
# First line of the script is the shebang which tells the system how to execute the script

echo Hello world! # => Hello world!

pwd # `pwd` stands for "print working directory"

ls # Lists the files and subdirectories contained in the current directory
ls -l # Lists every file and directory on a separate line
ls -t # Sorts the directory contents by last-modified date (descending)
ls -R # Recursively `ls` this directory and all of its subdirectories

ls -l | grep "\.txt" # The `grep` command filters the input with provided patterns

clear # Ctrl-L also works for clearing output

cat file.txt # Print files to stdout

cp srcFile.txt clone.txt # Copy files or directories
cp -r srcDirectory/ dst/ # Recursively copy

mv source.txt dst.txt # Move files or directories

(echo "First, I'm here: $PWD") && (cd someDir; echo "Then, I'm here: $PWD") # Use subshells to work across directories
```

#### Variables and strings

```
Variable="Some string"

echo $Variable # => Some string
echo "$Variable" # => Some string
echo '$Variable' # => $Variable

echo ${Variable} # => Some string

echo ${Variable/Some/A} # => A string

Length=7
echo ${Variable:0:Length} # => Some st
echo ${Variable: -5} # => tring

echo ${#Variable} # => 11

OtherVariable="Variable"
echo ${!OtherVariable} # => Some String

echo ${Foo:-"DefaultValueIfFooIsMissingOrEmpty"} # => DefaultValueIfFooIsMissingOrEmpty

#
# Built-in variables:
echo "Last program's return value: $?"
echo "Script's PID: $$"
echo "Number of arguments passed to script: $#"
echo "All arguments passed to script: $@"
echo "Script's arguments separated into different variables: $1 $2..."

echo "I'm in $(pwd)" # execs `pwd` and interpolates output
echo "I'm in $PWD" # interpolates the variable
```

#### Arrays

```
array0=(one two three four five six)
echo $array0 # => "one"
echo ${array0[0]} # => "one"
echo ${array0[@]} # => "one two three four five six"
echo ${#array0[@]} # => "6"
echo ${#array0[2]} # => "5"
echo ${array0[@]:3:2} # => "four five"
for i in "${array0[@]}"; do
    echo "$i"
done

echo {1..10} # => 1 2 3 4 5 6 7 8 9 10
echo {a..z} # => a b c d e f g h i j k l m n o p q r s t u v w x y z
```

#### IO

```
echo "What's your name?"
read Name # Note that we didn't need to declare a new variable
echo Hello, $Name!
```

#### If-Else and Loops

```
if [ "$Name" != $USER ]
then
    echo "Your name isn't your username"
else
    echo "Your name is your username"
fi

echo "Always executed" || echo "Only executed if first command fails" # => Always executed
echo "Always executed" && echo "Only executed if first command does NOT fail"
    # => Always executed
    # => Only executed if first command does NOT fail

if [ "$Name" == "Steve" ] && [ "$Age" -eq 15 ]
then
    echo "This will run if $Name is Steve AND $Age is 15."
fi

if [ "$Name" == "Daniya" ] || [ "$Name" == "Zach" ]
then
    echo "This will run if $Name is Daniya OR Zach."
fi

case "$Variable" in
    # List patterns for the conditions you want to meet
    0) echo "There is a zero.";;
    1) echo "There is a one.";;
    *) echo "It is not null.";;  # match everything
esac

for Variable in {1..3}
do
    echo "$Variable"
done

for ((a=1; a <= 3; a++))
do
    echo $a
done

while [ true ]
do
    echo "loop body here..."
    break
done
```

#### Regex

```
Email=me@example.com
if [[ "$Email" =~ [a-z]+@[a-z]{2,}\.(com|net|org) ]]
then
    echo "Valid email!"
fi
```

#### Expressions

```
echo $(( 10 + 5 )) # => 15
```

#### Functions

```
function foo ()
{
    echo "Arguments work just like script arguments: $@"
    echo "And: $1 $2..."
    echo "This is a function"
    returnValue=0    # Variable values can be returned
    return $returnValue
}

foo arg1 arg2 # Call the function `foo` with two arguments, arg1 and arg2

resultValue=$? # Return values can be obtained with $?

foo "My name is" $Name

bar ()
{
    echo "Another way to declare functions!"
    return 0
}

bar # Call the function `bar` with no arguments
```
