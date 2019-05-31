## Setup Haskell

### Installation

#### Windows

Download the [Haskell Platform](https://www.haskell.org/platform/).  

Run "cabal user-config init" and make sure it includes:  
```
extra-prog-path: C:\Program Files\Haskell Platform\x.y.z\msys\usr\bin
extra-lib-dirs: C:\Program Files\Haskell Platform\x.y.z\mingw\lib
extra-include-dirs: C:\Program Files\Haskell Platform\x.y.z\mingw\include
```

Run WinGHCi!  

### Features

* everything is a function
* everything is immutable (always create a new structure)
* everything is an expression
* has no side effects unless they are explicitely stated (pure/impure)

Haskell natively supports [literal programming](https://wiki.haskell.org/Literate_programming).  

### Terminal and Haskell file

Open the terminal with "ghci".  
Create a file called "<file_name>.hs".  
Load the file into the terminal with :l <file_name>.  
