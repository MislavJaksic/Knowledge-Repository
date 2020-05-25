## [Cloud SDK](https://cloud.google.com/sdk/)

For interacting with Google Cloud.  

### Install and Setup

```
Note: create a Google Cloud Platform project

$: python -V

Note: download archive

$: pwd  #-> $HOME
$: tar zxvf Archive-Name google-cloud-sdk
$: ./google-cloud-sdk/install.sh
```

```
$: gcloud init  # -> Opens browser!
```

```
$: gcloud compute regions list
$: gcloud config set compute/region Region-Name

$: gcloud compute zones list
$: gcloud config set compute/zone Zone-Name
```

[QuickStarts](QuickStarts)  
