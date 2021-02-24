## [pyswagger](https://github.com/pyopenapi/pyswagger)

Swagger enabled RESTAPI client.  

Adjacent tools:
* swagger-codegen
* swagger-py
* flex

```
class Swaggerer:
    def __init__(self, swagger_uri):
        self.app = App.create(swagger_uri)
        self.client = Client()

    def do(self, operation_id, **parameters):
        operation = self.create_operation(operation_id)
        response = self.client.request(operation(**parameters))
        return JsonResponse(response)

    def create_operation(self, operation_id):
        return self.app.op[operation_id]

class JsonResponse:  # response.data cannot be pickled
    def __init__(self, py_swagger_response):
        self.status = py_swagger_response.status
        self.header = py_swagger_response.header
        self.json = self.parse_json(py_swagger_response.raw)

    def parse_json(self, raw):
        return json.loads(raw)
```
