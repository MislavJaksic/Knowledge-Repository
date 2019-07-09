-- === HTML ===

-- div [_attributes] [_children]

-- button [onClick _msg] [text "_text"]

-- input [type_ _type, placeholder "_backgound_text", value _value, onInput _msg] []

-- === BROWSER ===

-- Browser.sandbox
--   { init = init
--   , update = update
--   , view = view 
--   }
  
-- Browser.element
--   { init = init
--   , update = update
--   , subscriptions = subscriptions
--   , view = view
--   }

-- Browser.document
--   { init : flags -> ( model, Cmd msg )
--   , view : model -> Document msg
--   , update : msg -> model -> ( model, Cmd msg )
--   , subscriptions : model -> Sub msg
--   }

-- Browser.application
--   { init : flags -> Url -> Key -> ( model, Cmd msg )
--   , view : model -> Document msg
--   , update : msg -> model -> ( model, Cmd msg )
--   , subscriptions : model -> Sub msg
--   , onUrlRequest : UrlRequest -> msg
--   , onUrlChange : Url -> msg
--   }

-- === URLS ===

-- Browser.UrlRequest

-- when parsing URLs you can define your own parser

-- type Route
--   = BlogPost Int String
--   | BlogQuery (Maybe String)

-- routeParser : Parser (Route -> a) a
-- routeParser =
--   oneOf
--     [ map BlogPost  (s "blog" </> int </> string)
--     , map BlogQuery (s "blog" <?> Query.string "q")
--     ]

-- /blog/14/whale-facts  ==>  Just (BlogPost 14 "whale-facts")
-- /blog/14              ==>  Nothing
-- /blog/whale-facts     ==>  Nothing
-- /blog/                ==>  Just (BlogQuery Nothing)
-- /blog                 ==>  Just (BlogQuery Nothing)
-- /blog?q=chabudai      ==>  Just (BlogQuery (Just "chabudai"))
-- /blog/?q=whales       ==>  Just (BlogQuery (Just "whales"))
-- /blog/?query=whales   ==>  Just (BlogQuery Nothing)

-- also supports fragments

-- type alias Docs =
--   (String, Maybe String)

-- docsParser : Parser (Docs -> a) a
-- docsParser =
--   map Tuple.pair (string </> fragment identity)

-- /Basics     ==>  Just ("Basics", Nothing)
-- /Maybe      ==>  Just ("Maybe", Nothing)
-- /List       ==>  Just ("List", Nothing)
-- /List#map   ==>  Just ("List", Just "map")
-- /List#      ==>  Just ("List", Just "")
-- /List/map   ==>  Nothing
-- /           ==>  Nothing

-- === HTTP ===

-- init : () -> (Model, Cmd Msg)
-- init _ =
--   ( Loading
--   , Http.get
--       { url = "http://www.gutenberg.org/cache/epub/6456/pg6456.txt"
--       , expect = Http.expectString GotText
--       }
--   )

-- === JSON DECODERS ===

-- if you want to access data.image_url in:
{
  "data": {
    "type": "gif",
    "id": "l2JhxfHWMBWuDMIpi",
    "title": "cat love GIF by The Secret Life Of Pets",
    "image_url": "https://media1.giphy.com/media/l2JhxfHWMBWuDMIpi/giphy.gif",
    "caption": "",
    ...
  },
  "meta": {
    "status": 200,
    "msg": "OK",
    "response_id": "5b105e44316d3571456c18b3"
  }
}
-- then:

gifDecoder : Decoder String
gifDecoder =
  field "data" (field "image_url" string)
  
-- map2: snap two decoders together
-- map3: snap three decoders together
-- map4: snap four decoders together
-- elm-json-decode-pipeline: for working with large JSON objects
-- bool: Decoder Bool
-- list: Decoder a -> Decoder (List a)
-- dict: Decoder a -> Decoder (Dict String a)
-- oneOf: List (Decoder a) -> Decoder a
