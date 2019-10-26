## [Postman](https://www.getpostman.com/)

Postman is a program used for creating and sending HTTP requests as well as receiving responses.  

### [Installation](https://learning.getpostman.com/docs/postman/launching_postman/installation_and_updates)

Windows notes: none  
Linux notes: requires "libgconf-2-4"  

### [Documentation](https://learning.getpostman.com/docs/postman/launching_postman/installation_and_updates)

HTTP methods: GET, PUT, POST, DELTE, HEAD, ...  
Requests must have a HTTP method and a URL and may have parameters.  

Requests can be saved and grouped into Collections.  

TODO

### Example REST request

```
HTTP method: GET  
URL: localhost:8080/topic/test_topic  
Headers: {key:"Contenty-Type", value:"application/json"}  
Body: { "number_of_partitions" : "1",
        "replication_number" : "1"
      }

```
