import Data.Char

main = do -- glue multiple IO actions
    putStrLn "Name?" --inpure IO: print
    name <- getLine --inpure IO: read
    if null name
        then return ()
        else do
          putStrLn ("Hey " ++ upperName name ++ "!")
          main

-- upperName :: (a -> b) -> [a] -> [b]
upperName x = map toUpper x