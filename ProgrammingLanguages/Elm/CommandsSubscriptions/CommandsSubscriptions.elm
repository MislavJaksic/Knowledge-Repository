-- commands and subscriptions allow Elm to interact with the outside world

-- === COMMANDS ===

-- type Msg
--   = GotText (Result Http.Error String)

-- init : () -> (Model, Cmd Msg)
-- init _ =
--   ( Loading
--   , Http.get
--       { url = "https://elm-lang.org/assets/public-opinion.txt"
--       , expect = Http.expectString GotText -- -> creates a message GotText
--       }
--   )

-- === SUBSCRIPTIONS ===

