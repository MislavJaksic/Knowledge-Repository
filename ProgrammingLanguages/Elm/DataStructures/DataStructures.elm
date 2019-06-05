-- === VALUES ===

"hello" ++ "world"
(2 + 3) * 4
9 / 2
9 // 2

-- === FUNCTIONS ===

double n = n * 2

double 2
double -7

(\n -> n < 0) 4

-- === LISTS ===

numbers = [1,4,3,2]

List.isEmpty numbers
List.length numbers
List.reverse numbers
List.sort numbers

List.map double numbers

-- === TUPLES ===

-- Consider using records instead.

(True, "Accepted!")

-- === RECORDS ===

bill = { name = "Gates", age = 62 }

bill.name
.name bill

under70 {age} = age < 70
under70 bill
under70 { species = "Triceratops", age = 68000000 }

{ bill | name = "Nye" }
{ bill | age = 22 }