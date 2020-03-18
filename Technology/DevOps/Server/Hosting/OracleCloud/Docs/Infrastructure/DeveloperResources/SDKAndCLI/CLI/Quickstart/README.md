## [Quickstart](https://docs.cloud.oracle.com/en-us/iaas/Content/API/SDKDocs/cliinstall.htm)

### Install

#### Linux

```
$: bash -c "$(curl -L https://raw.githubusercontent.com/oracle/oci-cli/master/scripts/install/install.sh)"
```

#### Windows

Open PowerShell as Administrator.  

```
$: Set-ExecutionPolicy RemoteSigned
$: powershell -NoProfile -ExecutionPolicy Bypass -Command "iex ((New-Object System.Net.WebClient).DownloadString('https://raw.githubusercontent.com/oracle/oci-cli/master/scripts/install/install.ps1'))"
```

##### Installation Script Prompts

```
...
===> In what directory would you like to place the install? (leave blank to use '/home/.../lib/oracle-cli'):
===> In what directory would you like to place the 'oci' executable? (leave blank to use '/home/.../bin'):
===> In what directory would you like to place the OCI scripts? (leave blank to use '/home/.../bin/oci-cli-scripts'):
===> Currently supported optional packages are: ['db (will install cx_Oracle)']
What optional CLI packages would you like to be installed (comma separated names; press enter if you don't need any optional packages)?:

===> Modify profile to update your $PATH and enable shell/tab completion now? (Y/n):
===> Enter a path to an rc file to update (leave blank to use '/home/mislavj/.bashrc'):
-- Backed up '/home/mislavj/.bashrc' to '/home/mislavj/.bashrc.backup'
-- Tab completion set up complete.
-- If tab completion is not activated, verify that '/home/mislavj/.bashrc' is sourced by your shell.
--
-- ** Run `exec -l $SHELL` to restart your shell. **
```

```
$: oci
```

### Setting up the Config File

```
$: oci setup config
```

[Find User and Tenancy OCID](../../../ToolsConfiguration/KeysAndOCIDs)

```
Enter a location for your config [/home/.../.oci/config]:
Enter a user OCID: ocid1.user.oc1..Very-Long-String
Enter a tenancy OCID: ocid1.tenancy.oc1..Another-Very-Long-String
Enter a region (e.g. ap-melbourne-1, ...): Region-Name
Do you want to generate a new RSA key pair? (If you decline you will be asked to supply the path to an existing key.) [Y/n]: n
Enter the location of your private key file: /home/.../.oci/oci_api_key.pem
Enter the passphrase for your private key: ***
Do you want to write your passphrase to the config file? (if not, you will need to supply it as an argument to the CLI) [y/N]: y
```

A config file is created in `/home/.../.oci/config`.  
