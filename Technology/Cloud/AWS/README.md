## AWS

[The Open Guide to Amazon Web Services](https://github.com/open-guides/og-aws)

### Quick notes

```
IAM IC: AWS permission, programmatic access
Cognito: user groups, user sign-up/out, user domai, authentication/authorization, JWT tokens
API Gateway: expose data
CloudFormation: like Helm Chart, stacks are connected resources
CloudWatch: for observability
S3: stores files
Lambda: max function time is 15 min
```

### IAM: Identity and Access Management

Answers: who can access what.

#### Configuring Programmatic Access

Recommended way:
* use IAM IC (previously AWS SSO)
    * Follow [AWS Programmatic Access](https://docs.aws.amazon.com/IAM/latest/UserGuide/security-creds.html#access-keys-and-secret-access-keys) and use `aws configure sso --profile <profile-name>` and leave `SSO session name (Recommended):` empty for legacy formatted config
    * On Windows: `setx AWS_PROFILE "<profile-name>"`, on Linux: `export AWS_PROFILE="<profile-name>"` to set the named profile
    * Check: `aws configure list`
    * Login: `aws login --profile <profile-name>`
    * Authenticate: `aws/sam <command> --profile <profile-name>`

### DynamoDB

All values are string.  
Can't perform aggregate functions.  
PartiSQL can only do SELECT, FROM and WHERE.  
Scan operation only fetch 1 MB at a time which requires lenghty and quirky pagination.  
Cannot rename table. Must use backup or import.  
Import can only be done when creating a new empty table.  
Importing into existing tables can be done using Lambda.  

### SNS: Simple Notification Service

For sending text messages. If you want to send pretty HTML tables, use SES.  
Cannot customize message branding.  
