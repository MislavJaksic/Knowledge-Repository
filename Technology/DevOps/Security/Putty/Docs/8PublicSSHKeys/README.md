## [Using public keys for SSH authentication](https://the.earth.li/~sgtatham/putty/0.73/htmldoc/Chapter8.html#pubkey)

AuthN using a key pair, not a password.  
PuTTY's authentication agent is called `Pageant`.  

### Using PuTTYgen, the PuTTY key generator

`PuTTYgen` is a key generator.  
`PuTTYgen` generates pairs of public and private keys.  

```
$: puttygen  # -> a window pops up
```

#### Generate

Select key type.  
Press `Generate`.  
Enter a comment and a passphrase.  
Press `Save private key` (in `*.ppk` format).  

Copy your public key to the server.  
Keep your private key secure.  

Key fingerprint is a human readable value generated from the public key.  

#### Load

Press `Load`.  
Enter passphrase.  

#### Conversions

SSH-2 private keys have no standard format.  
You can export and import different formats using `Conversions`.  

### Getting ready for public key authentication

TODO

Connect to your SSH server using PuTTY with the SSH protocol. When the connection succeeds you will be prompted for your user name and password to login. Once logged in, you must configure the server to accept your public key for authentication:

    If your server is OpenSSH, you should change into the .ssh directory under your home directory, and open the file authorized_keys with your favourite editor. (You may have to create this file, if this is the first key you have put in it.) Then switch to the PuTTYgen window, select all of the text in the ‘Public key for pasting into OpenSSH authorized_keys file' box (see section 8.2.10), and copy it to the clipboard (Ctrl+C). Then, switch back to the PuTTY window and insert the data into the open file, making sure it ends up all on one line. Save the file.

    (In very old versions of OpenSSH, SSH-2 keys had to be put in a separate file called authorized_keys2. In all current versions, the same authorized_keys file is used for both SSH-1 and SSH-2 keys.)
    If your server is ssh.com's product and is using SSH-2, you need to save a public key file from PuTTYgen (see section 8.2.9), and copy that into the .ssh2 directory on the server. Then you should go into that .ssh2 directory, and edit (or create) a file called authorization. In this file you should put a line like Key mykey.pub, with mykey.pub replaced by the name of your key file.
    For other SSH server software, you should refer to the manual for that server.

You may also need to ensure that your home directory, your .ssh directory, and any other files involved (such as authorized_keys, authorized_keys2 or authorization) are not group-writable or world-writable; servers will typically ignore the keys unless this is done. You can typically do this by using a command such as

chmod go-w $HOME $HOME/.ssh $HOME/.ssh/authorized_keys

Your server should now be configured to accept authentication using your private key. Now you need to configure PuTTY to attempt authentication using your private key. You can do this in any of three ways:

    Select the private key in PuTTY's configuration. See section 4.23.8 for details.
    Specify the key file on the command line with the -i option. See section 3.8.3.18 for details.
    Load the private key into Pageant (see chapter 9). In this case PuTTY will automatically try to use it for authentication if it can.
