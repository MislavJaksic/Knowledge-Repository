## [Google Sheets](https://www.google.com/sheets/about/)

Create Dashboards, calculate, take notes and analyze data imported from the web or files.

### Functions

```
VLOOKUP - is this value in the first column? If so, get a value in the same row offset by a number of columns
HLOOKUP - like VLOOKUP, but searches through for a key through the row

INDEX - return a value offset by a number of columns and rows
MATCH - return the relative position of a value in a range

SUMIFS - sum, but also used to specify multiple column search conditions

SORTN - get first N rows sorted by condition applied to a column

JOIN - concatenate
A1&B2 - like join but it can be used with ARRAYFORMULA
SUBSTITUTE - replace

ARRAYFORMULA - populate the formula through many cells; hotkey is CTRL + SHIFT + ENTER
ISNA - True if #N/A
NA - #N/A value
FILTER - filter by condition
ENCODEURL - turn a cell into a URL ready data
```

[Function list: Help](https://support.google.com/docs/table/25273)

### Tips and Tricks

ARRAYFORMULA and Filters conflict unless you use:
```
={"Column-Header-Name";ARRAYFORMULA(Array-Formula))}
```

### Scripts

#### JSON

[Import JSON from URL](https://github.com/bradjasper/ImportJSON)

### URL

#### Encoded characters

```
whitespace is %20
neline is %0A
```

### Script Editor

#### Logs

```
View -> Logs -> Apps Script Dashboard
```
