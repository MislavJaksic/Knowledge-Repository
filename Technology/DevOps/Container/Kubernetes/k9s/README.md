## [k9s](https://k9scli.io/)

A tool for managing Kubernetes clusters similar to `top` and `kubectl`.  

### Install

#### Linux

Download the [release](https://github.com/derailed/k9s/releases) for the appropriate OS architecture.  

```
$: uname -m  # list architecture
$: tar -xzvf Package-Name  # extract k9s
```

Don't install using `snap`! [It doesn't work](https://github.com/derailed/k9s/issues/267).  

### Usage

```
$: ./k9s [--readonly]  # run the binary
```

```
CTRL+W  # shows additional info, including resource, CPU and memory, usage
```
