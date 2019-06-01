-- lambda functions are nameless throwaway functions
-- lambda functions begin with \ and take paramaters before ->
result = map (\(a,b) -> a + b) [(1,2), (3,4), (5,6)] -- [3,7,11]