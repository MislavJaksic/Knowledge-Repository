=== MODULE ===

Made up of export functions and unexported functions.
Import with "import SphereGeometry".

> module SphereGeometry
> ( sphereVolume
> , sphereArea
> , Shape(Circle, Rectangle)
> ) where

> sphereVolume :: Float -> Float
> sphereVolume radius = (4.0 / 3.0) * pi * (radius ^ 3)

> sphereArea :: Float -> Float
> sphereArea radius = 4 * pi * (radius ^ 2)

> data Shape = Circle Point Double | Rectangle Point Point deriving Show

Unexported functions are below exported by convention.

> rectangleArea :: Float -> Float -> Float
> rectangleArea a b = a * b
