REPORT  HashTable.

*Hash tables are a special kind of internal tables
TYPES: BEGIN OF columns,
         key_column TYPE i,
         data_column TYPE string,
       END OF columns.
data row type columns.

data hash_table type HASHED TABLE OF columns with unique key key_column.

*Cannot APPEND, only INSERT 
row-key_column = 2.
row-data_column = 'Two'.
insert row into table hash_table.
row-key_column = 3.
row-data_column = 'Three'.
insert row into table hash_table.

READ TABLE hash_table with table key key_column = 2 into row.
write / row-data_column. "-> Two