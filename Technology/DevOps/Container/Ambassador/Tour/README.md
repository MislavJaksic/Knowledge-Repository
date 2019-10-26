## Ambassador Service Tour

Connect to the Ambassador service.  

```
$: minikube service ambassador
```

### Declerative Configuration

Ambassador is configured through Kubernetes annotations, not REST API.  
This way you can manage configuration using source control and its consistent with Kubernetes.  

### Multi Platform

Can be integrated with Consul.  

### Diagnostics and Monitoring

```
http://AMBASSADOR-SERVICE-IP:PORT/ambassador/v0/diag/
```

### Single Sign-on

Only comes with Ambassador Pro.  

### Rate Limiting

Advanced features only comes with Ambassador Pro.  

### Service Preview

Only comes with Ambassador Pro.  
