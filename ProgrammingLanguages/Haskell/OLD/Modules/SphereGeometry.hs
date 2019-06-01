-- import with "import SphereGeometry"
-- a module
-- export functions
module SphereGeometry
( sphereVolume
, sphereArea
) where

sphereVolume :: Float -> Float  
sphereVolume radius = (4.0 / 3.0) * pi * (radius ^ 3)  
  
sphereArea :: Float -> Float  
sphereArea radius = 4 * pi * (radius ^ 2)  



-- does not export
rectangleArea :: Float -> Float -> Float  
rectangleArea a b = a * b