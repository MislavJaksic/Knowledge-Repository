## InvokeHTTP

FlowFile attributes are converted to HTTP headers and the FlowFile contents are included as the body of the request.  

### Properties

| Name                             | Description |
|----------------------------------|-------------|
| HTTP Method                      | The uniform interface. |
| Remote URL                       | Endpoint URI. |
| SSL Context Service              |             |
| Connection Timeout               |             |
| Read Timeout                     |             |
| Idle Timeout                     |             |
| Max Idle Connections             |             |
| Include Date Header              |             |
| Follow Redirects                 |             |
| Disable HTTP/2                   |             |
| Attributes to Send               |             |
| Useragent                        |             |
| Basic Authentication Username    |             |
| Basic Authentication Password    |             |
| Proxy Configuration Service      |             |
| Proxy Host                       | Self evident. |
| Proxy Port                       | Self evident. |
| Proxy Type                       |             |
| Proxy Username                   |             |
| Proxy Password                   |             |
| Put Response Body In Attribute   |             |
| Max Length To Put In Attribute   |             |
| Use Digest Authentication        |             |
| Always Output Response           |             |
| Add Response Headers to Request  |             |
| Content-Type                     | For example: "text/xml;charset=utf-8" |
| Send Message Body                |             |
| Use Chunked Encoding             |             |
| Penalize on "No Retry"           |             |
| Use HTTP ETag                    |             |
| Maximum ETag Cache Size          |             |
| Ignore response's content        |             |
| FlowFile Form Data Name          |             |
| Set FlowFile Form Data File Name |             |


HTTP Method: POST
Remote URL: https://servisi.bisnode.si/BisnodeWebService/BisnodeWebServiceV3.asmx
Content-Type: text/xml;charset=utf-8 