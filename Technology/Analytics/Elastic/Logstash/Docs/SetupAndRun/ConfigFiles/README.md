## [Logstash Configuration Files](https://www.elastic.co/guide/en/logstash/current/config-setting-files.html)

Pipeline configuration files define the processing pipeline.  
Settings files control Logstash startup and execution.  

### Pipeline Configuration Files
edit

Place pipeline files in `/etc/logstash/conf.d`.  
Logstash loads only files with `.conf` extension.  

### Settings Files

`logstash.yml`:
* Logstash configuration flags
* override using command line arguments

`pipelines.yml`:
* framework and instructions for running multiple pipelines in a single Logstash instance

`jvm.options`:
* JVM configuration flags
* set initial and maximum values for total heap space

`log4j2.properties`:
* settings for the logging library

`startup.options` (Linux):
* options used by the `system-install` script in `/usr/share/logstash/bin` to build the appropriate startup script for your system
* sets options such as the user, group, service name, and service description
* makes it easier for you to install multiple instances of the Logstash service
