## [Manual:Pywikibot/Installation](https://www.mediawiki.org/wiki/Manual:Pywikibot/Installation)

### Installation Methods

PAWS: A Web Shell, no installation, use a web interface to submit commands  
Toolforge: a hosting environment where you can run the bots continuously or on a schedule  
On your own computer: you'll need to continue following this Guide  

### Install Python

Install Python 3.5 of higher.  

#### Install dependencies

```
$: pip install "requests>=2.20.1"
```

### Install Pywikibot

They originally suggest grabbing it with Git.  

```
$: poetry add pywikibot
```

#### Updating Pywikibot

Again, they originally suggest updating it through Git.  
I suggest you use `Poetry`.  

### Configure Pywikibot

```
$: python pwb.py generate_user_files
$: python pwb.py login
```

TODO

#### Use on third-party wikis

Pywikibot is pre-configured for a large number of wikis, but possibly not for the one you want to work on. See Manual:Pywikibot/Use on third-party wikis for how to configure Pywikibot for your wiki.
More configuration options

Pywikibot provides a wide range of configuration options to change the behavior of your bot. You can change these settings in the file user-config.py. See config2.py for a list of all parameters you can use.
Proxy configuration

Pywikibot relies on requests for communicating with the web. You can use HTTP_PROXY and HTTPS_PROXY environment variables to make requests use a proxy server. Refer to requests' documentation for more info.

Run a script

Pywikibot comes packaged with a large number of scripts in the scripts directory. You can run all of these using:

$ python pwb.py [name of the script]

A list of all scripts is available at Manual:Pywikibot/Scripts.
Other dependencies

Most scripts do not require additional packages, but a few of them will not work without. These are listed in requirements.txt together with their dependencies.

To install dependencies for some script, use pip, and run the following command:

$ pip install [name of the package]

Alternatively, run the following command to install all dependencies for all scripts at once:

$ pip install -r requirements.txt


    If you need more help on setting up your Pywikibot visit the #pywikibot IRC channel connect or pywikibot@ mailing list.
