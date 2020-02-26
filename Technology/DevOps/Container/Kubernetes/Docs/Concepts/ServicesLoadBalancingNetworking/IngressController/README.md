## [Ingress Controllers](https://kubernetes.io/docs/concepts/services-networking/ingress-controllers/)

`Ingress` resources work only when an `Ingress Controller` is running.
Kubernetes supports and maintains:
* `GCE` controller
* `nginx` controller

### Additional controllers

* `Ambassador` `API Gateway` is an `Envoy` based ingress controller with community or commercial support from `Datawire`.

* `AppsCode Inc.` offers support and maintenance for the most widely used `HAProxy` based ingress controller `Voyager`.

* `AWS ALB` `Ingress Controller` enables ingress using the `AWS Application` `Load Balancer`.

* `Contour` is an `Envoy` based ingress controller provided and supported by `VMware`.

* `Citrix` provides an `Ingress Controller` for its hardware (MPX), virtualized (VPX) and free containerized (CPX) ADC for baremetal and cloud deployments.

* `F5 Networks` provides support and maintenance for the `F5 BIG-IP Controller` for Kubernetes.

* `Gloo` is an open-source ingress controller based on `Envoy` which offers `API Gateway` functionality with enterprise support from solo.io.

* `HAProxy Ingress` is a highly customizable community-driven ingress controller for `HAProxy`.

* `HAProxy Technologies` offers support and maintenance for the `HAProxy` `Ingress Controller` for Kubernetes. See the official documentation.

* `Istio` based ingress controller `Control Ingress Traffic`.

* `Kong` offers community or commercial support and maintenance for the `Kong` `Ingress Controller` for Kubernetes.

* `NGINX, Inc.` offers support and maintenance for the `NGINX` `Ingress Controller` for Kubernetes.

* `Skipper` HTTP router and reverse proxy for service composition, including use cases like Kubernetes `Ingress`, designed as a library to build your custom proxy

* `Traefik` is a fully featured ingress controller (`Let’s Encrypt`, secrets, http2, websocket), and it also comes with commercial support by `Containous`.

### Using multiple Ingress controllers

You may deploy [any number of ingress controllers](https://github.com/kubernetes/ingress-nginx/blob/master/docs/user-guide/multiple-ingress.md#multiple-ingress-controllers) within a cluster.  
Annotate each `Ingress` with `ingress.class` to indicate which `Ingress Controller` should be used.  
Your cloud provider may use a default `Ingress Controller`.
