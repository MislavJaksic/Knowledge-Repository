## [CFSSL](https://github.com/cloudflare/cfssl)

Public Key Infrastructure (PKI) and TLS command line tool and an HTTP API server for signing, verifying, and bundling TLS certificates.  

### Install

[Install Go](../../../../Software/ProgrammingLanguage/Go)  

```
$: git clone https://github.com/cloudflare/cfssl.git
$: cd cfssl
$: make

$: cd bin
$: sudo mv cfssl /usr/local/bin/cfssl
$: sudo mv cfssljson /usr/local/bin/cfssljson
```

Restart your computer.  

```
$: cfssl version
$: cfssljson --version
```
