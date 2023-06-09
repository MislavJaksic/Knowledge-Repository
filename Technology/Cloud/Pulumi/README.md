## Pulumi

### Lexicon

```
Project - represents a Pulumi program
Program - declares desired infrastructure
Stack - like dev, uat and prod, isolated environments or feature branches

Resource - basic building block such as a bucket, a database or compute instance
Resource provider - AWS, Docker and the like 
Language host - Python, Java and the like

Resource input - values provided to the resource
Resource output - resource's properties, known only after the resource was provisioned
Resource dependency/reference - recources can depend on other resources

Stack output - values exported by a stack
Stack reference - allow you to access the outputs of one stack from another stack

Component resource - abstracts and encapsulates building blocks

Pulumi API - for creating infrastructure platforms other developers can use
```

### AWS Credentials

Known bug with AWS SSO Session: [support sso-session](https://github.com/pulumi/pulumi-aws/issues/2272)
Resolved with `aws configure sso` and leaving `SSO session name (Recommended):` empty:
```
[profile cli-admin]
sso_start_url = https://<value>.awsapps.com/start#
sso_region = <value>
sso_account_id = <value>
sso_role_name = <value>
region = <value>
output = json
```

### Import

`pulumi import <package>:<module>:<typename> <pulumi-name> <resource-provider-name>`
If on AWS you have a AWS S3 Bucket called `X` then you'd write: `pulumi import aws:s3/bucket:Bucket <pulumi-name> X`.
If on AWS you have a AWS DynamoDB Table called `Y` then you'd write: `pulumi import aws:dynamodb/table:Table <pulumi-name> Y`.
In general you can find the import command on Pulumi resource provider's pages, such as [eventrule](https://www.pulumi.com/registry/packages/aws/api-docs/cloudwatch/eventrule/).
