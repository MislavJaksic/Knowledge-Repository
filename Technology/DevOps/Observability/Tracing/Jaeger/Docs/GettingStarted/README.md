## [Getting Started](https://www.jaegertracing.io/docs/1.16/getting-started/)

### Instrumentation

Apps must be instrumented before they can send `Trace`s to Jaeger.  
See [Client Libraries](../ClientLibraries)

### All in One

```
# Note: install Docker

$: docker run -d --name jaeger -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 -p 14250:14250 -p 9411:9411 jaegertracing/all-in-one:1.16
```

```
http://localhost:16686
```

See [Kubernetes Jaeger Operator](../Deployment/Kubernetes).  

### Sample App:HotROD

```
$: docker run --rm -it --link jaeger -p8080-8083:8080-8083 -e JAEGER_AGENT_HOST="jaeger" jaegertracing/example-hotrod:1.16 all
```

```
http://localhost:8080
```

[HotROD Tutorial](https://medium.com/opentracing/take-opentracing-for-a-hotrod-ride-f6e3141f7941)

### Migrating from Zipkin

TODO
