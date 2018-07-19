names='Marvin Shooty Hactar Magrathea'
for name in $names; do
  echo $name;
done

# OR

echo "Brojevi od 42 do 27 djeljivi s 3:"
for (( i =42; i >=27; i =i-3)) do
  echo $i
done

cnt=0
while [ $cnt -le 10 ]; do
  echo $cnt;
  (( cnt ++));
done

cnt=15
until [ $cnt - lt 10 ]; do
  echo $cnt;
  (( cnt--));
done

distros ='Ubuntu Arch CentOS Gentoo Quit'
select distro in $distros; do
  if [ $distro == 'Quit' ]; then
    break;
  fi;
  echo Tvoja je omiljena distribucija $distro ;
done
