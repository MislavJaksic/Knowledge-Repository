## [Quickstart for Linux](https://cloud.google.com/sdk/docs/quickstart-linux)

### Before you begin

```
Note: create a Google Cloud Platform project

$: python -V

Note: download archive

$: pwd  #-> $HOME
$: tar zxvf Archive-Name google-cloud-sdk
$: ./google-cloud-sdk/install.sh
```

### Initialize the SDK

```
$: gcloud init  # -> Opens browser!
```

Select default `Compute Engine` regions/zones if you haven't already.  

```
$: gcloud compute regions list
$: gcloud config set compute/region Region-Name

$: gcloud compute zones list
$: gcloud config set compute/zone Zone-Name
```

### Run core gcloud commands

```
$: gcloud auth list
$: gcloud config list
$: gcloud info
$: gcloud help
```
