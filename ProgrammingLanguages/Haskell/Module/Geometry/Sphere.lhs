=== SUBMODULE ===

A submodule in the folder Geometry.
Import with "import qualified Geometry.Sphere as Sphere".

> module Geometry.Sphere  
> ( volume  
> , area  
> ) where  
  
> volume :: Float -> Float  
> volume radius = (4.0 / 3.0) * pi * (radius ^ 3)  
  
> area :: Float -> Float  
> area radius = 4 * pi * (radius ^ 2)  