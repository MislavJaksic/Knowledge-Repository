## User Settings

Click of your portrait in the top right corner of GitLab.com.  

### [SSH Keys](https://gitlab.com/help/ssh/README#generating-a-new-ssh-key-pair)

On Windows:
```
$: git-gui
# Note: Help -> Show SSH Key -> Generate Key -> Copy (Public Key) To Clipboard
```

On Linux:
```
$: ssh-keygen -t ed25519 -C "gitlab-git"  -> generates a public-private key pair
  # Enter file in which to save the key (/home/_user/.ssh/id_ed25519): /home/_user/.ssh/id_ed25519-gl-g
$: cat /home/_user/.ssh/id_ed25519-gl-g.pub  -> prints the PUBLIC key
  # ssh-ed25519 A-Long-String gitlab-git
```

Register the PUBLIC KEY at GitLab: click your profile picture -> Settings -> SSH Keys -> Copy-Paste the PUBLIC key  

```
# Note: make sure to setup your identity
$: git config --global user.name "John Doe"
$: git config --global user.email johndoe@example.com
```

```
$: git fetch origin  #-> test if it works
  # The authenticity of host 'gitlab.com (35.231.145.151)' can't be established.
  # ECDSA key fingerprint is SHA256:HbW3g8zUjNSksFbqTiUWPWg2Bq1x8xdGUrliXFzSnUw.
  # Are you sure you want to continue connecting (yes/no)? yes
  # Warning: Permanently added 'gitlab.com,35.231.145.151' (ECDSA) to the list of known hosts.
OR
$: ssh -T git@gitlab.com
```
