=== IF-THEN-ELSE ===

Else is mandatory.

> doubleSmall x = if x > 100
>                   then x
>                   else x + x

Avoid explicitly returning True/False.
                  
> bigBad x = if x > 100
>              then True
>              else False

> bigGood x = x > 100
