## [Generate and add an SSH key](https://gitlab.com/help/ssh/README#generating-a-new-ssh-key-pair)

### Generate

#### Windows

```
$: git-gui
# Note: Help -> Show SSH Key -> Generate Key -> Copy (Public Key) To Clipboard
```

#### Linux

```
$: ssh-keygen -t ed25519 -C "gitlab-git"  -> generates a public-private key pair
  # Enter file in which to save the key (/home/_user/.ssh/id_ed25519): /home/_user/.ssh/id_ed25519-gl-g
$: cat /home/_user/.ssh/id_ed25519-gl-g.pub  -> prints the PUBLIC key
  # ssh-ed25519 A-Long-String gitlab-git
# Note: copy "ssh-ed25519 A-Long-String gitlab-git" to clipboard
```

### Add an SSH key to GitLab

Copy your PUBLIC key (.pub) into your clipboard.  

Add your PUBLIC key to GitLab by clicking your profile picture -> Settings -> SSH Keys -> Copy-Paste the PUBLIC key.  

### Test

```
$: ssh -T git@gitlab.com
  # The authenticity of host 'gitlab.com (35.231.145.151)' can't be established.
  # ECDSA key fingerprint is SHA256:HbW3g8zUjNSksFbqTiUWPWg2Bq1x8xdGUrliXFzSnUw.
  # Are you sure you want to continue connecting (yes/no)? yes
  # Warning: Permanently added 'gitlab.com,35.231.145.151' (ECDSA) to the list of known hosts.
```

If something goes wrong:
```
$: ssh -vvvT git@gitlab.com
```

### Working with non-default SSH key pair paths
### Per-repository SSH keys
### Deploy keys
### Applications
### SSH on the GitLab server
### Troubleshooting
