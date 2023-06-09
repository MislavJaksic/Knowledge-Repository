## AWS

[The Open Guide to Amazon Web Services](https://github.com/open-guides/og-aws)

```
IAM: AWS permissions only
IAM IC: AWS permission, programmatic access
Cognito: user groups, user sign-up/out, user domai, authentication/authorization, JWT tokens, 
API Gateway: expose data
CloudFormation: like Helm Chart, stacks are connected resources
CloudWatch: for observability
SNS: send emails, SMS, ...
S3: stores files
DynamoDB: all values are string, can't perform aggregate functions, PartiSQL can only do SELECT, FROM and WHERE, scan operation only fetch 1 MB at a time which requires lenghty and quirky pagination
Lambda: max function time is 15 min
```

### IAM

#### Configuring Programmatic Access

Recommended way:
* use IAM IC (previously AWS SSO)
    * Follow [AWS Programmatic Access](https://docs.aws.amazon.com/IAM/latest/UserGuide/security-creds.html#access-keys-and-secret-access-keys) and use `aws configure sso --profile <profile-name>` and leave `SSO session name (Recommended):` empty for legacy formatted config
    * On Windows: `setx AWS_PROFILE "<profile-name>"`, on Linux: `export AWS_PROFILE="<profile-name>"` to set the named profile
    * Check: `aws configure list`
    * Login: `aws login --profile <profile-name>`
    * Authenticate: `aws/sam <command> --profile <profile-name>`

