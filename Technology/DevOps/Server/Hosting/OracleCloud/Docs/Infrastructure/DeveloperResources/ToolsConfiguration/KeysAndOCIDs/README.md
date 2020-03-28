## [Required Keys and OCIDs](https://docs.cloud.oracle.com/en-us/iaas/Content/API/Concepts/apisigningkey.htm)

A client needs:
1) to create a user in `IAM`
2) get:
    * RSA key pair in PEM format
    * fingerprint of the public key
    * tenancy's OCID and user's OCID
3) upload the public key from the key pair in the `Console`
4) if using an Oracle tool, supply the credentials in a file or a config object

This is not the `SSH` key used to access remote computers!  

### How to Generate an API Signing Key

Windows users need to install [Git Bash for Windows](https://git-scm.com/download/win).  

```
$: mkdir ~/.oci

# Linux
$: openssl genrsa -out ~/.oci/oci_api_key.pem -aes128 2048
# Windows
$: openssl genrsa -out ~/.oci/oci_api_key.pem -aes128 -passout stdin 2048

$: chmod go-rwx ~/.oci/oci_api_key.pem

# Linux
$: openssl rsa -pubout -in ~/.oci/oci_api_key.pem -out ~/.oci/oci_api_key_public.pem
# Windows
$: openssl rsa -pubout -in ~/.oci/oci_api_key.pem -out ~/.oci/oci_api_key_public.pem -passin stdin

$: cat ~/.oci/oci_api_key_public.pem | pbcopy
```

### How to Get the Key's Fingerprint

```
openssl rsa -pubout -outform DER -in ~/.oci/oci_api_key.pem | openssl md5 -c
```

### Where to Get the Tenancy's OCID and User's OCID

Login to the `Console`.  

```
Navigation menu -> Governance and Administration -> Administration -> Tenancy Details -> Tenancy Information -> OCID
```

```
Profile -> User Settings
OR
Navigation menu -> Governance and Administration -> Administration -> Identity -> Users -> select a user
```

### How to Upload the Public Key

1) Login to the `Console`.  
2) Interfaces:
  * ```Profile -> User Settings```
  * ```Identity -> Users -> select user```
3) Add Public Key
4) Paste the PEM public key
