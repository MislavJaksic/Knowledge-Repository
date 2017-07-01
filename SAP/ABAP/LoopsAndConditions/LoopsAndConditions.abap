REPORT  LoopsAndCond.

data boolean type i value 0.
if boolean = 1.
  elseif boolean = 0.
    write / 'Zero'.
    endif.

while boolean > 0.
  write / 'I didn''t enter while'.
  endwhile.

do 5 times.
  write sy-index.
  enddo.

do.
  sy-subrc = 5. "intentionally cause an error
  if sy-subrc <> 0. "if there was en error
    exit. "exit endless loop
    endif.
  enddo.