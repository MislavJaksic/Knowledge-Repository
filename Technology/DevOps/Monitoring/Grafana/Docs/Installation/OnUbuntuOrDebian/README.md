## [Install on Debian or Ubuntu](https://grafana.com/docs/grafana/latest/installation/debian/)

### 1. Download and install

Install either the paying Enterprise edition or OSS release.  

#### OSS release

```
$: sudo apt-get install -y apt-transport-https
$: sudo apt-get install -y software-properties-common wget
$: wget -q -O - https://packages.grafana.com/gpg.key | sudo apt-key add -

$: sudo add-apt-repository "deb https://packages.grafana.com/oss/deb stable main"

$: sudo apt-get update
$: sudo apt-get install grafana
```

### 2. Start the server

#### systemd

```
$: sudo systemctl daemon-reload
$: sudo systemctl start grafana-server
$: sudo systemctl status grafana-server
```

```
$: sudo systemctl enable grafana-server.service  # configure to start at boot
```

#### init.d

```
$: sudo service grafana-server start
$: sudo service grafana-server status

$: sudo service grafana-server stop
```

```
$: sudo update-rc.d grafana-server defaults  # configure to start at boot
```

#### Execute binary

```
$: ./bin/grafana-server web
```
