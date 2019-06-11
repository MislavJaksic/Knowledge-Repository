=== SUBMODULE ===

A submodule in the folder Geometry.
Import with "import qualified Geometry.Cube as Cube".

> module Geometry.Cube  
> ( volume  
> , area  
> ) where  
  
> import qualified Geometry.Cuboid as Cuboid  
  
> volume :: Float -> Float  
> volume side = Cuboid.volume side side side  
  
> area :: Float -> Float  
> area side = Cuboid.area side side side  