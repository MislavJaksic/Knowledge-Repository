## Edge Policy Console

### Login

```
# Note: navigate to https://Kubectl-Service-IP:Node-Port
```

### Install

#### Linux

```
$: sudo curl -fL https://metriton.datawire.io/downloads/linux/edgectl -o /usr/local/bin/edgectl && sudo chmod a+x /usr/local/bin/edgectl
```

### Usage

```
$: edgectl login --namespace=ambassador Ambassador-Host
```
