type User
  = Regular String Int
  | Visitor String

-- === PATTERN MATCHING ===

-- === CASE EXPRESSION ===

toName : User -> String
toName user =
  case user of
    Regular name _ -> -- -> _ is a wild card, a discarded arugment
      name

    Visitor name ->
      name

-- === GUARDS ===

