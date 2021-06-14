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

Copy your PUBLIC key (.pub) to the clipboard.  
Register the PUBLIC KEY at GitLab:
```
Profile -> Settings -> SSH Keys -> copy-paste the PUBLIC key  
```

### Test

```
$: ssh -T git@gitlab.com
  # ...
  # Are you sure you want to continue connecting (yes/no)? yes
  # ...
```

If something goes wrong:
```
$: ssh -vvvT git@gitlab.com
```

### Working with non-default SSH key pair paths

TODO

### Per-repository SSH keys

TODO

### Deploy keys

TODO

### Applications

TODO

### SSH on the GitLab server

TODO

### Troubleshooting

TODO
