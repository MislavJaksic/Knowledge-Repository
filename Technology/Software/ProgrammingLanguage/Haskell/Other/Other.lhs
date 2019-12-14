> import System.Random
> import System.Environment
> import System.IO
> import System.IO.Error

=== CONVENTIONS ===

Use camelCase for function and variable names.
_: ignore this value.

=== RANDOMNESS ===

Random
RandomGen

=== BYTESTRINGS ===

Bytestrings are efficient character lists.
Strings defined as [Char] are very inefficient.

=== EXCEPTIONS ===

try
catch
bracket

doesFileExist
isDoesNotExistError
ioError

isAlreadyExistsError
isDoesNotExistError
isAlreadyInUseError
isFullError
isEOFError
isIllegalOperation
isPermissionError
isUserError

userError

ioeGetFileName
