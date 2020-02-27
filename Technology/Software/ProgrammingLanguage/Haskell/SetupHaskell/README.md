## Setup Haskell

### Installation

#### Windows (recommended)

Download Haskell [Stack](https://docs.haskellstack.org/en/stable/README/), a project manager.  
`Stack` prevents a dependency hell.  

`stack ghci` installs and runs the interactive interpreter.  

#### Windows (beginner, not recommended)

Download the [Haskell Platform](https://www.haskell.org/platform/).  

Run `cabal user-config init` and make sure it includes:  
```
extra-prog-path: C:\Program Files\Haskell Platform\x.y.z\msys\usr\bin
extra-lib-dirs: C:\Program Files\Haskell Platform\x.y.z\mingw\lib
extra-include-dirs: C:\Program Files\Haskell Platform\x.y.z\mingw\include
```

Run `WinGHCi`!  

### Features

* everything is a function
* everything is immutable (always creates a new structure)
* everything is an expression
* has no side effects unless they are explicitly stated (pure/impure)

Haskell natively supports [literal programming](https://wiki.haskell.org/Literate_programming).  

Haskell has an interactive interpreter (like Python or JavaScript).  

#### Literal programming

Module has an extension `*.lhs`.  
Module can be written in [Bird style](https://wiki.haskell.org/Literate_programming#Bird_Style).  

#### Interpreter

Open the terminal with `ghci`.  
Create a file called `Module-Name.hs`.  
Load the file into the terminal with `:l Module-Name`.  

### Compile

A module can be compiled if it has a `main` function.  
Compile a module with `ghc Module-Name.hs`  
Run with `./Module-Name`.  
OR  
Compile and run with `runhaskell Module-Name.hs`.  
