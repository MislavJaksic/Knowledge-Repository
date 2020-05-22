## [Prerequisites](https://github.com/kelseyhightower/kubernetes-the-hard-way/blob/master/docs/01-prerequisites.md)

You will need to:
* sign up for [Google Cloud Platform](../../../../../Server/Hosting/GoogleCloudPlatform)
* install and setup [Cloud SDK (gcloud)](../../../../../Server/Hosting/GoogleCloudPlatform/CloudSDK)
* install [tmux](../../../../../../OS/Linux/Tmux)

### After installing Cloud SDK

```
$: gcloud version
$: gcloud init

$: gcloud auth login

$: gcloud compute zones list
$: gcloud config set compute/region Region-Name
$: gcloud config set compute/zone Zone-Name
```

### After installing tmux

Enable synchronize-panes:
* `ctrl+b` then `shift+:`
* `set synchronize-panes on`

Disable synchronize-panes:
* `set synchronize-panes off`
