## (Simple) simplex method example

| Problem: |  |
| -- | -- |
| Maximize: | P = 40*x1* + 30*x2* |
| If: | *x1* + 2*x2* =< 16 |
|  | *x1* + *x2* =< 9 |
|  | 3*x1* + 2*x2* =< 24 |
|  | *x1*, *x2* > 0 |

Rewrite the maximization function so that P is positive and 0 is on one side of the equation.

If you have to minimize instead of maximize the function, flip the signs of the variable in the objective function and then pretend you are maximizing.

If =< add a slack variable to the inequality to convert it to an equality.

If => add a negative slack variable and an artificial variable to convert it to an equality.

If = add an artificial variable to convert it to a correct equality.

| =< to = |
| -- |
| *x1* + 2*x2* + *s1* = 16 |
| *x1* + *x2* + *s2* = 9 |
| 3*x1* + 2*x2* + *s3* = 24 |

| x1 | x2 | s1 | s2 | s3 | P | C | Comment |
| -- | -- | -- | -- | -- | -- | -- | -- |
| 1 | 2 | 1 | 0 | 0 | 0 | 16 |  16/1 = 16 |
| 1 | 1 | 0 | 1 | 0 | 0 | 9 |  9/1 = 9 |
| 3 | 2 | 0 | 0 | 1 | 0 | 24 |  24/3 = 8, divide row by *x1*=3 |
| -40 | -30 | 0 | 0 | 0 | 1 | 0 |    |

8 is the smallest value in C column (it determines the row)

-40 is the smallest value in the last row (it determines the column)

| x1 | x2 | s1 | s2 | s3 | P | C | Comment |
| -- | -- | -- | -- | -- | -- | -- | -- |
| 1 | 2 | 1 | 0 | 0 | 0 | 16 |  |
| 1 | 1 | 0 | 1 | 0 | 0 | 9 |  |
| 1 | 2/3 | 0 | 0 | 1 | 0 | 8 | set other values in column *x1* to 0
| -40 | -30 | 0 | 0 | 0 | 1 | 0 |  |

| x1 | x2 | s1 | s2 | s3 | P | C | Comment |
| -- | -- | -- | -- | -- | -- | -- | -- |
| 0 | 4/3 | 1 | 0 | -1 | 0 | 8 | 8\*3/4 = 6 |
| 0 | 1/3 | 0 | 1 | -1 | 0 | 1 | 1\*3 = 3, multiply row by 3 |
| 1 | 2/3 | 0 | 0 | 1 | 0 | 8 | 8\*3/2 = 12 |
| 0 | -10/3 | 0 | 0 | 40 | 1 | 320 |  |

3 is the smallest value in C column (it determines the row)

-10/3 is the smallest value in the last row (it determines the column)

| x1 | x2 | s1 | s2 | s3 | P | C | Comment |
| -- | -- | -- | -- | -- | -- | -- | -- |
| 0 | 4/3 | 1 | 0 | -1 | 0 | 8 |  |
| 0 | 1 | 0 | 3 | -3 | 0 | 3 | set other values in column *x2* to 0 |
| 1 | 2/3 | 0 | 0 | 1 | 0 | 8 |  |
| 0 | -10/3 | 0 | 0 | 40 | 1 | 320 |  |

| x1 | x2 | s1 | s2 | s3 | P | C | Comment |
| -- | -- | -- | -- | -- | -- | -- | -- |
| 0 | 0 | 1 | -4 | 3 | 0 | 4 | *s1* = 4 |
| 0 | 1 | 0 | 3 | -3 | 0 | 3 | *x2* = 3 |
| 1 | 0 | 0 | -2 | 7 | 0 | 6 | *x1* = 6 |
| 0 | 0 | 0 | 30 | 30 | 1 | 330 | P = 330 |

Stop condition: there are no negative values in the last row

*s2* and *s3* are 0 because they are in mixed values columns.

P = 40\*6 + 30\*3 = 240 + 90 = 330

We have validated the solution by plugging in the numbers into the original equation.