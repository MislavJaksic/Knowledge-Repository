## SOAP Request

Query a SOAP endpoint.  

### Processors

```
GenerateFileFlow -> ReplaceText -> InvokeHTTP
```

#### GenerateFileFlow

Default.  

#### ReplaceText

Replacement Value: SOAP-Request-Envelope

#### InvokeHTTP

HTTP Method: POST
Remote URL: SOAP-URI
Content-Type: text/xml;charset=utf-8 