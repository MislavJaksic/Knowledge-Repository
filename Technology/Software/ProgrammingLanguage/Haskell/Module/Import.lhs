=== IMPORT MODULES ===

Simple module import.

> import Data.List

Prevent naming conflicts by qualifying modules.

> import qualified Data.Map as M

Include only a few functions from a module.

> import Data.List (nub, sort)

Import all except the hidden function.

> import Data.List hiding (nub)
