## [Getting Started](https://linkerd.io/2/getting-started/)

### Step 0: Setup

You will need:
* `Kubernetes` 1.13 or later
* `kubectl`

```
$: kubectl version --short
```

### Step 1: Install the CLI

```
$: curl -sL https://run.linkerd.io/install | sh
# Note: add `export PATH=$PATH:$HOME/.linkerd2/bin` to `~/.bashrc` on Ubuntu

$: linkerd version  # ->
  # Client version: stable-X.Y.Z
  # Server version: unavailable
```

### Step 2: Validate your Kubernetes cluster

```
$: linkerd check --pre  # fix all issues before continuing
```

### Step 3: Install Linkerd onto the cluster

```
$: linkerd install config | kubectl apply -f -  # install in namespace `linkerd`
$: linkerd check config  # fix all issues before continuing

$: linkerd install control-plane | kubectl apply -f -  # install in namespace `linkerd`
$: linkerd check  # fix all issues before continuing
```

WARNING: tap api service FailedDiscoveryCheck!!! kubectl get apiservice shows an error!!! Tap Pod did not recognise certificate: linkerd2_proxy_identity::certify Failed to certify identity:!!!

### Step 4: Explore Linkerd

```
$: linkerd dashboard &
```

### Step 5: Install the demo app

To get a feel for how Linkerd would work for one of your services, you can install a demo application. The emojivoto application is a standalone Kubernetes application that uses a mix of gRPC and HTTP calls to allow the users to vote on their favorite emojis.

Install emojivoto into the emojivoto namespace by running:

curl -sL https://run.linkerd.io/emojivoto.yml \
  | kubectl apply -f -

Before we mesh it, let's take a look at the app. If you're using Docker Desktop at this point you can visit http://localhost directly. If you're not using Docker Desktop, we'll need to forward the web-svc service. To forward web-svc locally to port 8080, you can run:

kubectl -n emojivoto port-forward svc/web-svc 8080:80

Now visit http://localhost:8080. Voila! The emojivoto app in all its glory.

Clicking around, you might notice that some parts of emojivoto are broken! For example, if you click on a doughnut emoji, you'll get a 404 page. Don't worry, these errors are intentional. (And we can use Linkerd to identify the problem. Check out the debugging guide if you're interested in how to figure out exactly what is wrong.)

Next, let's add Linkerd to emojivoto by running:

kubectl get -n emojivoto deploy -o yaml \
  | linkerd inject - \
  | kubectl apply -f -

This command retrieves all of the deployments running in the emojivoto namespace, runs the manifest through linkerd inject, and then reapplies it to the cluster. The linkerd inject command adds annotations to the pod spec instructing Linkerd to add ("inject") the proxy as a container to the pod spec. (See Automatic Proxy Injection for more.)

As with install, inject is a pure text operation, meaning that you can inspect the input and output before you use it. Once piped into kubectl apply, Kubernetes will execute a rolling deploy and update each pod with the data plane's proxies, all without any downtime.

Congratulations! You've now added Linkerd to existing services! Just as with the control plane, it is possible to verify that everything worked the way it should with the data plane. To do this check, run:

linkerd -n emojivoto check --proxy

Step 6: Watch it run

You can now view the Linkerd dashboard and see all the services in the demo app. Since the demo app comes with a load generator, we can see live traffic metrics by running:

linkerd -n emojivoto stat deploy

This will show the "golden" metrics for each deployment:

    Success rates
    Request rates
    Latency distribution percentiles

To dig in a little further, it is possible to use top to get a real-time view of which paths are being called:

linkerd -n emojivoto top deploy

To go even deeper, we can use tap shows the stream of requests across a single pod, deployment, or even everything in the emojivoto namespace:

linkerd -n emojivoto tap deploy/web

All of this functionality is also available in the dashboard, if you would like to use your browser instead:
Top Line Metrics
Top Line Metrics
Deployment Detail
Deployment Detail
Top
Top
Tap
Tap

What about things that happened in the past? Linkerd includes Grafana to visualize the metrics collected by Prometheus, and ships with some pre-configured dashboards. You can get to these by clicking the Grafana icon in the overview page.
Deployment Detail Dashboard
Deployment Detail Dashboard
That's it! 👏

Congratulations, you're now a Linkerd user! Here are some suggested next steps:

    Use Linkerd to debug the errors in emojivoto
    Add your own service to Linkerd without downtime
    Learn more about Linkerd's architecture
    Hop into the #linkerd2 channel on the Linkerd Slack

Welcome to the Linkerd community!
