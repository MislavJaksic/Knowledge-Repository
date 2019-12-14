> import Data.Char
> import System.IO
> import System.Environment

=== IO ACTIONS ===

IO actions are inpure functions, functions that cause side effects.
Side effects are caused by a change in system state or outside interaction.
IO is a type constructor of kind "* -> *".

IO a -- -> IO action, returns "a"
IO String -- -> IO action, returns "String"
IO Int -- -> IO action, returns "Int"
IO () -- -> IO action, returns nothing ("()" is called a unit)

=== MAIN FUNCTION AND TERMINAL IO ===

There can be only one "main" function.
A program with a "main" function can be compiled and run.

A Hello World program:
  main1 = putStrLn "Hello, world!" -- -> takes a string, prints it on screen and returns an IO action

You can join multiple actions into one action with "do":
main2 = do
  name <- getLine -- -> perform an IO action, unwraps the type and binds the result to a variable
  putStrLn \$ "Hello," ++ name

The return value of the "do" block is the return value of the last action.

"return" in Haskell is not the same as in other programming languages:
main3 = do
    return "Hello" -- -> does not end execution!
    line <- getLine
    return "World" -- -> takes a value, wraps it into an IO action and returns an IO action

> main = do
>   putStrLn "Name?"
>   name <- getLine
>   if null name
>     then return ()
>     else do
>       putStrLn ("Hey " ++ upperName name ++ "!")
>       main

> upperName :: String -> String
> upperName x = map toUpper x

It is possible to use "let" and "where" with IO actions.

=== IO FUNCTIONS ===

putStr -- -> print without newline
putChar -- -> print without newline
putStrLn -- -> print with newline
print -- -> print an instance of "Show"

getChar -- -> read from input

when -- -> takes a boolean value and a function; if True return the function, if False return ()

sequence  -- -> chains IO actions into a single action

mapM -- -> takes a function and a list, then maps over the list
forM -- -> like mapM but takes an IO action for every list element

forever -- -> repeat an IO action

=== STREAMS ===

Read until you hit an end-of-file.
Useful when piping outputs as inputs into another program.

> main21 :: IO ()
> main21 = do
>   s <- getContents
>   putStr $ map toUpper s

unlines -- -> join list with newline
lines -- -> split input by whitecharacter

interact -- -> takes a function, return an IO action that takes in string and outputs a string

> main22 :: IO ()
> main22 = interact (map toUpper)

== FILES ===

openFile -- -> takes a string and IOMode then returns a IO Handle that will open a file
IOMode -- -> ReadMode | WriteMode | AppendMode | ReadWriteMode
IO Handle -- -> represents file location
hGetContents -- -> continously read from the Handle
hClose -- -> close the file Handle

> main31 = do
>   handle <- openFile "girlfriend.txt" ReadMode
>   contents <- hGetContents handle
>   putStr contents
>   hClose handle

withFile -- -> takes a string and IOMode and a function then closes the file
hPutStr
hPutStrLn
hGetLine
hGetChar
hGetContents

readFile
writeFile
appendFile

hFlush
openTempFile
removeFile
renameFile

=== COMMAND LINE ARGUMENTS ===

getArgs -- -> read arguments
getProgName -- -> read module name
