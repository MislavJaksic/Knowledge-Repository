## LibreOffice Regex

```
?: lazy match
(...): group, mutiple reasons
\1: `Find` reference
$1: `Replace` reference
```

* Delete wrapper characters.  
* Extract the middle of a string.  
```
Find: \{\{em\|(.*?)\}\}
Replace: ''$1''

{{em|within}} -> ''within''
```
