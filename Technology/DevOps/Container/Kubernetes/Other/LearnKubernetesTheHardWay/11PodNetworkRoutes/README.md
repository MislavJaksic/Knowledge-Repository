## [Provisioning Pod Network Routes](https://github.com/kelseyhightower/kubernetes-the-hard-way/blob/master/docs/11-pod-network-routes.md)

`Pod`s receive an IP address from the `Node`'s `Pod` `CIDR` range.  
Configure network routes so `Pod`s can communicate with `Pod`s running on different `Node`s.  

Create a route for each worker `Node` that maps the `Node`'s `Pod` `CIDR` range to the `Node`'s internal IP address.  

See [other ways of implementing the Kubernetes networking model](https://kubernetes.io/docs/concepts/cluster-administration/networking/#how-to-achieve-this).  

### The Routing Table

```
$: for instance in worker-0 worker-1 worker-2; do
  gcloud compute instances describe ${instance} \
    --format 'value[separator=" "](networkInterfaces[0].networkIP,metadata.items[0].value)'
done
```

### Routes

```
$: for i in 0 1 2; do
  gcloud compute routes create kubernetes-route-10-200-${i}-0-24 \
    --network kthw-vpc-network \
    --next-hop-address 10.240.0.2${i} \
    --destination-range 10.200.${i}.0/24
done
```

```
$: gcloud compute routes list --filter "network: kthw-vpc-network"
```
