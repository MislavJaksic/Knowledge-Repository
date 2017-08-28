## Lisp 

For Windows, download LispStick and then double click run.bat to start the
emacs. The interactive "interpreter" REPL will then open before you.

To save your defun functions, C+x C+f to make/find a file, type fileName.lisp and
then save it with C+x C+s. Write a defun into the file and compile it with C+c C+c.
To save your work after editing use C+x C+s.

After compiling, files can also be loaded into REPL with
(load "fileName.lisp").

You can open up a REPL window beside the file editing window with C+c C+z.

Lisp uses a Polish prefix notation. Example: (+ 2 3 4 5) -> 14

#Number
10
#String
"hello world"
#(format where-to-send-output what-to-output)
(format t "hello, world") -> standard output, hello world, nil
#(defun function-name (parameters) function-body)
(defun hello-world () (format t "hello, world")) -> hello-world
#(function-name)
(hello-world) -> standard output, hello world, nil
#(list arguments)
(list 1 2 3) ->
#Property list, plist, (list :symbolOne valueOne :...)
#Keyword symbols start with a colon (:)
(list :a 1 :b 2 :c 3) -> 
#(getf plist :symbol)
(getf (list :a 1 :b 2 :c 3) :b) -> 2
#Define func with args
(defun make-cd (title artist rating ripped)
  (list :title title :artist artist :rating rating :ripped ripped))
#Define global var
(defvar *db* nil)
#(push data onto-variable)
(push (list 1 2 3 4) *db*)
#dolist macro binding a list element to a variable (dolist (variable list) do-function)
#fancy format: ~{ ~} means consume a list and do with its member what is written between the commands
#              ~a consumes one argument from a list
#              ~10t means format the previous ~a to 10 spaces
#              ~% means add a newline
(dolist (cd *db*)
  (format t "~{~a:~10t~a~%~}~%" cd))
#format will output the value into *variable* instead of standard output
#(force-output var) makes sure Lisp doesn't wait for a newline before printing the prompt
#(read-line variable) reads a line of text and returns it
#return value of prompt-read will be the value of the last form, the call to READ-LINE, which returns the string it read
(defun prompt-read (prompt)
  (format *query-io* "~a: " prompt)
  (force-output *query-io*)
  (read-line *query-io*))
#validate input data with parse-integer, y-or-n-p and take a default value with or
(defun prompt-for-cd ()
  (make-cd
    (prompt-read "Title")
    (prompt-read "Artist")
    (or (parse-integer (prompt-read "Rating") :junk-allowed t) 0)
    (y-or-n-p "Ripped [y/n]: ")))
Stopped at Saving the database!




Common Lisp defines two black boxes, reader is the one that translates
text into Lisp objects and evaluator that implements the semantics of the
language in terms of those objects.

S-expressions: lists, atoms
  Lists: delimited by whitespace and brackets
    Elements of list: S-expressions
  Atoms: everything else
    Numbers: 12, -34, 1.0, 1.0e-4
	Strings: "foo", "f\\oo" (\ is the escape character)
	Names: format, hello-world, *db*, x, y are symbols

Naming convention:
* for global variables
+ for constants
- to separate words
; for comments
in emacs indent with TAB

Lisp form: 
any atom, any nonlist or empty list
list that has a symbol as its first element
  
Evaluator can be thought of as a function that takes a Lisp form as an
argument and returns a value.
  Atoms can be self evaluating such as strings and numbers, t and nil as
  well as keyword symbols (:a).
  Function call forms: evaluate the remaining elements of the list as Lisp forms and pass the resulting values to the named function
  Special form: special evaluation to make sure the language is capable of implementing if, loop and other features. There are around 25 
  Macro form: extend the Lisp syntax, unlike macros in other languages.
  Macro is a function that takes s-expressions as arguments and returns a
  Lisp form that's then evaluated in place of the macro form. The
  evaluation of a macro form proceeds in two phases: First, the elements
  of the macro form are passed, unevaluated, to the macro function.
  Second, the form returned by the macro function--called its expansion
  --is evaluated according to the normal evaluation rules.
  
Boolean values:
t is truth
nil is false
(), '() is nil

Equality:
always eql, never anything else
a is eql to b only if a and b have the same value and belong ot the same class. Example: (eql 1 1.0) -> nil; (eql 2 2) ->  t

Functions:
define -> (defun functionName (parameters*) "Doc string" body-form*)
optional args -> (defun foo (a b &optional c d) (list a b c d))
defulat values -> (defun foo (a &optional (b 10)) (list a b))
isArgSupplied? -> (defun foo (a &optional (c a c-supplied-p)) (list a c c-supplied-p))
rest of args -> (defun functionName (&rest numbers) ...)
keyword args -> (defun foo (&key a b c) (list a b c))
exit from a block of code -> (... (return-from foo (list i j)))

Higher order function: when functions accepts another function as an argument or when a function return a function as a return value
Store function: (function functionName) or #'functionName
Invoke stored function and you know how many arguments you are going to pass: (funcall #'functionName arg1 arg2 ...)
Invoke stored function and you don't know how many arguments you are going to pass: (apply #'functionName (list ...))

Anonymous functions (doesn't have a name):
(lambda (parameters) body)
(funcall #'(lambda (x y) (+ x y)) 2 3) -> 5
To pass lambda functions around, just prefix them with #'.

Variables:
  Lexical: local, working variables that can shadow other variables (including dynamic variables)
  Dynamic (aka special): global variables, marked with *
Lisp is dynamically typed and strongly typed.
Scoping and binding form: inner binding shadows the outer binding.
Binding form: construct that introduces a new variable name that is usable only within the construct
 By default all binding forms are lexically scoped.
 Closure: when a function closes over around the binding, so it is able to use the binding even outside the scope

 lexical binding -> (let (variable*) body-form*)
 dynamic binding -> (defparameter ...)
 constants -> (defconstant ...)
Setf behaves like =, assignment operator in C languages.
 assign a new value to a binding (lasts until you exit the scope) -> (setf place value)
Simple variable:    (setf x 10) 
Array:              (setf (aref a 0) 10)
Hash table:         (setf (gethash 'key hash) 10)
Slot named 'field': (setf (field o) 10)

Modify macros: use setf to perform an action
(incf x)    === (setf x (+ x 1)) -> increment
(decf x)    === (setf x (- x 1)) -> decrement
(incf x 10) === (setf x (+ x 10))
vars swap values -> (rotatef a b)
add var to var -> (push a b)

Macros in Lisp extend the language syntax, they can define new syntactic abstractions.

#(if condition then-form [else-form])
(if (> 2 3) "Yup" "Nope") -> "Nope"
#when and unless allow you to execute multiple Lisp form in then-form and else-form
(when (spam-p current-message)
  (file-in-spam-folder current-message)
  (update-spam-database current-message))
#cond is a multibranch conditional
(cond
  (test-1 form*)
      ...
  (test-N form*)
#boolean operators are: and, or, not
(and (= 1 2) (= 3 3)) -> NIL
#looping: do, dolist, dotimes, loop
(dolist (var list-form)
  body-form*)
(dolist (x (list 1 2 3)) (print x) (if (evenp x) (return)))
(dotimes (i 4) (print i))
#do is more general and powerful. all step-forms are calculated at the same time using the old values
(do (variable-definition*)   -> var def is: (var init-form step-form)
    (end-test-form result-form*)
  statement*)
(do ((n 0 (1+ n)) -> n begins as 0, step is n+1
     (cur 0 next) -> cur begins as 0, step is next
     (next 1 (+ cur next))) -> next begins as 1, step is cur+next
    ((= 10 n) cur))
#use loop if you need to loop over data structures or accumulate values
(loop -> simple inf loop form
  body-form*)
#symbols across, and, below, collecting, counting, finally, for, from, summing, then, and to are some of the loop keywords
(loop for i from 1 to 10 collecting i) -> (1 2 3 4 5 6 7 8 9 10)
(loop for x across "the quick brown fox jumps over the lazy dog"
      counting (find x "aeiou")) -> 11


#when macros are run its macro expansion time; when regular code is run its runtime
#macros will generate code
(defmacro name (parameter*)
  "Optional documentation string."
  body-form*)
#1)Write a sample call to the macro and the code it should expand into, or vice versa.
#2)Write code that generates the handwritten expansion from the arguments in the sample call.
#3)Make sure the macro abstraction doesn't "leak." that call should expand

#Stopped at A Sample Macro: do-primes, Chapter 8
