## AWS

```
IAM: handles AWS permissions only
IAM IC: handles permission, programmatic access
S3: stores files
DynamoDB: all values are string, can't perform aggregate functions, PartiSQL can only do SELECT, FROM and WHERE, scan operation only fetch 1 MB at a time which requires lenghty and quirky pagination
Lambda: max function time is 15 min
```

### IAM

#### Configuring Programmatic Access

The most complicated, but recommended way:
* use IAM IC (previously AWS SSO)

The simplest, but least recommended way:
* get the access keys from `login as IAM User -> IAM -> Users -> Security Credentials`
