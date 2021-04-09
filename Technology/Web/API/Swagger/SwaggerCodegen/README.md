## [Swagger Codegen](https://github.com/swagger-api/swagger-codegen)

### Python

```
# Note: download it
$: cd swagger-codegen
$: mvn clean package
$: java -jar modules\swagger-codegen-cli\target\swagger-codegen-cli.jar generate -i https://petstore.swagger.io/v2/swagger.json -l Programming-Language -o .\path\to\dir
# Note: this will generate a big project ready to be used
```
