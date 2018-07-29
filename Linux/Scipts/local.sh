#!/ bin/ bash
HELLO=Hello
function hello {
  local HELLO=World #local to this function
  echo $HELLO
}
echo $HELLO
hello
echo $HELLO
# Output: Hello World Hello