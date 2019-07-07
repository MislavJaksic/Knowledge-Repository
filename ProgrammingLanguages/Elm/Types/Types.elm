-- type variable: when you see "a"

-- === CONSTRAINED TYPES ===

-- number: permits Int and Float
-- appendable: permits String and List a
-- comparable: permits Int, Float, Char, String, and lists/tuples of comparable values
-- compappend: permits String and List comparable

-- === TYPE ALIASES ===

-- an alias also generates a record constructor

type alias User =
  { name : String
  , bio : String
  }
  
-- === ALGEBRAIC DATA TYPES ===

-- called custom types in Elm
-- custom types have varients

type User = Regular String Int | Visitor String

-- === MESSAGES ===

type Msg
  = PressedEnter
  | ChangedDraft String
  | ReceivedMessage {user : User, message : String}
  | ClickedExit

-- === MAYBE AND RESULT TYPE ===

-- treat errors as data
-- makes failure explicit

type Maybe a = Just a | Nothing

-- tells you why it failed

type Result error value = Ok value | Err error