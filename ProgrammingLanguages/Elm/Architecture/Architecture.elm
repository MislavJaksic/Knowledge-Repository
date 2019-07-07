-- === ELM ARCHITECTURE ===

-- Three parts:
--   Model — the state of your application
--   Update — a way to update your state
--   View — a way to view your state as HTML

-- === MODEL ===

-- Defines an immutable state with which the user can interact through messages.

-- Has an init function

-- === UPDATE ===

-- Defines how the user can interact with the application.
-- Messages are changes which the user can make.
-- Functions define how messages are processed.

-- === VIEW ===

-- Uses pure Elm (no templating language) to create a HTML response.

-- Elm HTML node functions take:
--  * a list of attributes
--  * a list of child nodes

-- div [_attributes] [_children]

-- === BUTTONS ===

-- button [onClick _msg] [text "_text"]

-- === TEXT FIELDS AND FORMS ===

-- input [type_ _type, placeholder "_backgound_text", value _value, onInput _msg] []
