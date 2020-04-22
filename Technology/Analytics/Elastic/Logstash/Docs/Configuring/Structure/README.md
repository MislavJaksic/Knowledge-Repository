## [Structure of a Config File](https://www.elastic.co/guide/en/logstash/current/configuration-file-structure.html#configuration-file-structure)

Has a separate section for each type of plugin.  

```
input {
  file {
    path => "/var/log/messages"
    type => "syslog"
  }

  file {
    path => "/var/log/apache/access.log"
    type => "apache"
  }
}

filter {
  ...
}

output {
  ...
}
```

### Plugin Configuration

Each plugin is configured in its own way.  
