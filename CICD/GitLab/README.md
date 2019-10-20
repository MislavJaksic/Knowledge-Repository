## [GitLab Docs](https://docs.gitlab.com/ee/README.html)

GitLab is a Git repository that also covers the entire DevOps Lifecycle.  

DevOps Lifecycle:
* manage: statistics and analytics
* plan: project planning and management
* create: commit code
* verify: test, check quality and CI
* package: package software
* release: app delivery
* configure: configure apps
* monitor: collect metrics
* secure: secure apps

## [Generating a new SSH key pair](https://gitlab.com/help/ssh/README#generating-a-new-ssh-key-pair)

Without an SSH key you have to input your username and password every time you execute a git command.  

To avoid this, generate and set an SSH key.  

```
$: ssh-keygen -t ed25519 -C "gitlab-git"  -> generates a public-private key pair
  # Enter file in which to save the key (/home/_user/.ssh/id_ed25519): /home/_user/.ssh/id_ed25519-gl-g
$: cat /home/_user/.ssh/id_ed25519-gl-g.pub  -> prints the PUBLIC key
  # ssh-ed25519 A-Long-String gitlab-git
```

Register the PUBLIC KEY at GitLab: click your profile picture -> Settings -> SSH Keys -> Copy-Paste the PUBLIC key  

```
$: git fetch origin  -> test if it works
  # The authenticity of host 'gitlab.com (35.231.145.151)' can't be established.
  # ECDSA key fingerprint is SHA256:HbW3g8zUjNSksFbqTiUWPWg2Bq1x8xdGUrliXFzSnUw.
  # Are you sure you want to continue connecting (yes/no)? yes
  # Warning: Permanently added 'gitlab.com,35.231.145.151' (ECDSA) to the list of known hosts.
```
