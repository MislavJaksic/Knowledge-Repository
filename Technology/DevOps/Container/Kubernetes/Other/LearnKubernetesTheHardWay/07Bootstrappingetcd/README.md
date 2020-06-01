## [Bootstrapping the etcd Cluster](https://github.com/kelseyhightower/kubernetes-the-hard-way/blob/master/docs/07-bootstrapping-etcd.md)

Kubernetes components are stateless and store cluster state in `etcd`, a distributed key-value store.  

### Prerequisites

Login to each controller.  

```
$: gcloud compute ssh controller-0
$: gcloud compute ssh controller-1
$: gcloud compute ssh controller-2
```

#### Running commands in parallel with tmux

`tmux` can run commands on multiple machines at the same time.  

Steps:
* run `tmux`
* spit panes with `C-b "`
* move between panes with `C-b Arrow-Key`
* login with `gcloud compute ssh controller-X`
* synchronize panes with `C+b : set synchronize-panes on`

### Bootstrapping an etcd Cluster Member

#### Download and Install the etcd Binaries

```
$: wget -q --show-progress --https-only --timestamping "https://github.com/etcd-io/etcd/releases/download/v3.4.9/etcd-v3.4.9-linux-amd64.tar.gz"

$: tar -xvf etcd-v3.4.9-linux-amd64.tar.gz
$: sudo mv etcd-v3.4.9-linux-amd64/etcd* /usr/local/bin/
```

#### Configure the etcd Server

```
$: sudo mkdir -p /etc/etcd /var/lib/etcd
$: sudo cp ca.pem kubernetes-key.pem kubernetes.pem /etc/etcd/
```

Clients and `etcd` will communicate using the machines' internal IP address.  

```
$: INTERNAL_IP=$(curl -s -H "Metadata-Flavor: Google" http://metadata.google.internal/computeMetadata/v1/instance/network-interfaces/0/ip)
```

Each `etcd` member must have a unique name.  

```
$: ETCD_NAME=$(hostname -s)
```

```
$: cat <<EOF | sudo tee /etc/systemd/system/etcd.service
[Unit]
Description=etcd
Documentation=https://github.com/coreos

[Service]
Type=notify
ExecStart=/usr/local/bin/etcd \\
  --name ${ETCD_NAME} \\
  --cert-file=/etc/etcd/kubernetes.pem \\
  --key-file=/etc/etcd/kubernetes-key.pem \\
  --peer-cert-file=/etc/etcd/kubernetes.pem \\
  --peer-key-file=/etc/etcd/kubernetes-key.pem \\
  --trusted-ca-file=/etc/etcd/ca.pem \\
  --peer-trusted-ca-file=/etc/etcd/ca.pem \\
  --peer-client-cert-auth \\
  --client-cert-auth \\
  --initial-advertise-peer-urls https://${INTERNAL_IP}:2380 \\
  --listen-peer-urls https://${INTERNAL_IP}:2380 \\
  --listen-client-urls https://${INTERNAL_IP}:2379,https://127.0.0.1:2379 \\
  --advertise-client-urls https://${INTERNAL_IP}:2379 \\
  --initial-cluster-token etcd-cluster-0 \\
  --initial-cluster controller-0=https://10.240.0.10:2380,controller-1=https://10.240.0.11:2380,controller-2=https://10.240.0.12:2380 \\
  --initial-cluster-state new \\
  --data-dir=/var/lib/etcd
Restart=on-failure
RestartSec=5

[Install]
WantedBy=multi-user.target
EOF
```

#### Start the etcd Server

```
$: {
  sudo systemctl daemon-reload
  sudo systemctl enable etcd
  sudo systemctl start etcd
}
```

### Verification

```
$: sudo ETCDCTL_API=3 etcdctl member list --endpoints=https://127.0.0.1:2379 --cacert=/etc/etcd/ca.pem --cert=/etc/etcd/kubernetes.pem --key=/etc/etcd/kubernetes-key.pem
```
