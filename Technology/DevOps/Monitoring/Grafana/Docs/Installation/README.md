## [Installation](https://grafana.com/docs/installation/)

### Ubuntu

```
$: sudo apt-get install -y apt-transport-https
$: sudo apt-get install -y software-properties-common wget
$: wget -q -O - https://packages.grafana.com/gpg.key | sudo apt-key add -

$: sudo add-apt-repository "deb https://packages.grafana.com/oss/deb stable main"

$: sudo apt-get update
$: sudo apt-get install grafana
```

```
$: sudo service grafana-server start
$: sudo service grafana-server status

$: sudo service grafana-server stop
```
