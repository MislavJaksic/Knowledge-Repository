-- === LISTS ===

numbers = [1,4,3,2]

List.isEmpty numbers -- -> False
List.length numbers -- -> 4
List.reverse numbers -- -> [2,3,4,1]
List.sort numbers -- -> [1,2,3,4]

List.map double numbers -- -> [2,8,6,4]

-- === TUPLES ===

-- Consider using records instead.

(True, "Accepted!")

-- === RECORDS ===

bill = {name = "Gates", age = 62}

bill.name -- -> "Gates"
.name bill -- -> "Gates"

under70 {age} = age < 70
under70 bill -- -> True
under70 {species = "Triceratops", age = 68000000} -- -> False

{bill | name = "Nye"} -- -> {age = 62, name = "Nye"}
{bill | age = 22} -- -> {age = 22, name = "Gates"}