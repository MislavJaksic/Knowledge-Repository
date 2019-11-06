Is out of date.  

## [Nginx](https://www.nginx.com/resources/wiki/)

nginx is a free, simple and fast HTTP server, but it can also be much more then that.  

To protect communication you can use TCL.  
To use TCL you need a Certificate issued by a Certification Authority.  
[Let's Encrypt](https://letsencrypt.org/) is a CA that issued certificates for free.  
[nginx and Let's Encrypt Tutorial](https://www.digitalocean.com/community/tutorials/how-to-secure-nginx-with-let-s-encrypt-on-ubuntu-16-04)  

### [Installation](https://www.nginx.com/resources/wiki/start/topics/tutorials/install/)

Follow it to the letter. There shouldn't be any major problems.  
You can check if the installation was a success with "nginx -v".  

### [Begineer's Guide](http://nginx.org/en/docs/#introduction)

One master process and many workers.  
nginx configuration is stored in "/etc/nginx/nginx.conf".  

Start nginx using the executable "sudo nginx".  

Control nginx with signals using "sudo nginx -s _signal".  
> Signals:  
> stop — fast shutdown  
> quit — graceful shutdown  
> reload — reloading the configuration file  
> reopen — reopening the log files  

nginx is made up of modules controlled by directives.  
Directives are stored in configuration files.  
Directives can be simple or block.  
Simple directive end with ;.  
Block directives end with {} and they include additional instructions.  
Context is when a block directive is made of directives.  
\# is a line comment.  

Serving static content is quite simple, but requires nginx to be configured.  
Open nginx cofiguration file "sudo nano /etc/nginx/nginx.conf".  
You should also consult [config pitfalls](https://www.nginx.com/resources/wiki/start/topics/tutorials/config_pitfalls/)  

Sample nginx.conf on VirtualBox running Ubuntu bionic:
```
user nginx;
worker_processes 1;

error_log /var/log/nginx/error.log warn;
pid /var/run/nginx.pid;

events {
  worker_connections 1024;
}

http {
  include /etc/nginx/mime.types;
  default_type application/octet-stream;

  log_format main '$remote_addr - $remote_user [$time_local] "$request" '
                  '$status $body_bytes_sent "$http_referer" '
                  '"$http_user_agent" "$http_x_forwarded_for"';

  access_log /var/log/nginx/access.log  main;

  sendfile off; # Default on; set to off if using VirtualBox, see common pitfalls

  keepalive_timeout  65;

  #include /etc/nginx/conf.d/*.conf; # Uncommented by default
    server {
        listen       80;
        server_name  localhost;
	      root /home/mjaksic/pages; # Where files are located

	      error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   /usr/share/nginx/html;
        }

        location / {
            index index.html;
        }
    }
}
```

Sample folder structure and URI results:  
```
Folder structure:
/home/mjaksic/pages - index.html
                      page_one.html
                      other_pages - page_two.html
URIs and results:
localhost //-> 200 index.html
localhost/page_one.html //-> 200 page_one.html
localhost/other_pages/page_two.html //-> 200 page_two.html
localhost/other_pages //-> 403 Forbidden
everything_else //-> 404 Not found
```

nginx should now listen on port 80 for requests, serve static web pages and run in the background.  

### Serving web pages and services

nginx is just a server. It is not a web page or service framework.  
Python: uWSGI connects servers and Python frameworks  
