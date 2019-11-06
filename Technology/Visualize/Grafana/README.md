## [Grafana](https://grafana.com/docs/)

### [Installation](https://grafana.com/docs/installation/)

#### Ubuntu

```
$: wget https://dl.grafana.com/oss/release/grafana_Grafana-Version_amd64.deb
$: sudo apt-get install -y adduser libfontconfig1
$: sudo dpkg -i grafana_Grafana-Version_amd64.deb
```

```
$: sudo service grafana-server start

$: sudo service grafana-server stop
```

### [Getting Started](https://grafana.com/docs/guides/getting_started/)

```
# Note: visit http://localhost:3000/
# Note: default username and password are "admin"
```

Add and test a data source.  

Create a dashboard.  
