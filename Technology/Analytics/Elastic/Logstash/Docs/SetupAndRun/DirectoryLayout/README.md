## [Logstash Directory Layout](https://www.elastic.co/guide/en/logstash/current/dir-layout.html)

### Archive Layout

TODO

### Package Layout

TODO

### Docker Image Layout

| Type     | Description                                                             | Default Location             | Setting        |
|----------|-------------------------------------------------------------------------|------------------------------|----------------|
| home     | Home directory of the Logstash installation                             | /usr/share/logstash          |                |
| bin      | Binary scripts to start Logstash and to install plugins                 | /usr/share/logstash/bin      |                |
| settings | Configuration files, including logstash\.yml and jvm\.options           | /usr/share/logstash/config   | path\.settings |
| conf     | Logstash pipeline configuration files                                   | /usr/share/logstash/pipeline | path\.config   |
| plugins  | Local, non Ruby\-Gem plugin files\. Each plugin has a subdirectory      | /usr/share/logstash/plugins  | path\.plugins  |
| data     | Data files used by logstash and its plugins for any persistence needs   | /usr/share/logstash/data     | path\.data     |
