## [Cleaning Up](https://github.com/kelseyhightower/kubernetes-the-hard-way/blob/master/docs/14-cleanup.md)

### Compute Instances

```
$: gcloud -q compute instances delete controller-0 controller-1 controller-2 worker-0 worker-1 worker-2 --zone $(gcloud config get-value compute/zone)
```

### Networking

```
$: {
  gcloud -q compute forwarding-rules delete kubernetes-forwarding-rule \
    --region $(gcloud config get-value compute/region)

  gcloud -q compute target-pools delete kubernetes-target-pool

  gcloud -q compute http-health-checks delete kubernetes-health-check

  gcloud -q compute addresses delete kthw-address
}
```

```
$: gcloud -q compute firewall-rules delete \
  kthw-allow-nginx-service \
  kthw-firewall-internal \
  kthw-firewall-external \
  kthw-allow-health-check
```

```
$: {
  gcloud -q compute routes delete \
    kubernetes-route-10-200-0-0-24 \
    kubernetes-route-10-200-1-0-24 \
    kubernetes-route-10-200-2-0-24

  gcloud -q compute networks subnets delete kthw-subnet

  gcloud -q compute networks delete kthw-vpc-network
}
```
