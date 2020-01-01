## [How to Connect to Droplets with SSH](https://www.digitalocean.com/docs/droplets/how-to/connect-with-ssh/)

If you didn't setup SSH, a password is in an email.  

### Connect with OpenSSH

TODO

### Connect with PuTTY

In `Session`:
* fill in `Host Name (or IP address)` with `Droplet`'s `ipv4`
* change connection type to `SSH`
* fill in `Port` with 22
* fill in `Saved Sessions` at the end to reuse this configuration

In `Connection -> SSH -> Auth`:
* `Browse...` private SSH key; you passed its public key to the `Droplet` at creation

In `Connection -> Data`:
* fill in `Auto-login username` with `root`/`core`/`rancher`/`freebsd`

Click `Open` after you are done.  
