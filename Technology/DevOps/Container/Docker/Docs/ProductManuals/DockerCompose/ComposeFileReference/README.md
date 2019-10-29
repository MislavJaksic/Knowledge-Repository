## [Compose file reference](https://docs.docker.com/compose/compose-file/)

Example:
```
version: "3.7"
services:

  redis:
    image: redis:alpine
    ports:
      - "6379"
    networks:
      - frontend
    deploy:
      replicas: 2
      update_config:
        parallelism: 2
        delay: 10s
      restart_policy:
        condition: on-failure

  db:
    image: postgres:9.4
    volumes:
      - db-data:/var/lib/postgresql/data
    networks:
      - backend
    deploy:
      placement:
        constraints: [node.role == manager]

  vote:
    image: dockersamples/examplevotingapp_vote:before
    ports:
      - "5000:80"
    networks:
      - frontend
    depends_on:
      - redis
    deploy:
      replicas: 2
      update_config:
        parallelism: 2
      restart_policy:
        condition: on-failure

  result:
    image: dockersamples/examplevotingapp_result:before
    ports:
      - "5001:80"
    networks:
      - backend
    depends_on:
      - db
    deploy:
      replicas: 1
      update_config:
        parallelism: 2
        delay: 10s
      restart_policy:
        condition: on-failure

  worker:
    image: dockersamples/examplevotingapp_worker
    networks:
      - frontend
      - backend
    deploy:
      mode: replicated
      replicas: 1
      labels: [APP=VOTING]
      restart_policy:
        condition: on-failure
        delay: 10s
        max_attempts: 3
        window: 120s
      placement:
        constraints: [node.role == manager]

  visualizer:
    image: dockersamples/visualizer:stable
    ports:
      - "8080:8080"
    stop_grace_period: 1m30s
    volumes:
      - "/var/run/docker.sock:/var/run/docker.sock"
    deploy:
      placement:
        constraints: [node.role == manager]

networks:
  frontend:
  backend:

volumes:
  db-data:
```

### Service configuration reference

Compose file is a YML file defining services, networks and volumes.  

### build

#### context, dockerfile, args, cache_from, labels, shm_size, target

### cap_add, cap_drop

### cgroup_parent

### command

### configs

#### long and short syntax

### container_name

### credential_spec

### depends_on

### deploy

#### endpoint_mode, labels, mode, placement, replicas, resources, restart_policy, rollback_config, update_config

### devices

### depends_on

### dns

### dns_search

### entrypoint

### env_file

### environment

### expose

### external_links

### extra_hosts

### healthcheck

### image

### init

### isolation

### labels

### links

### logging

### network_mode

### networks

#### aliases, ipv4_address, ipv6_address

### pid

### ports

#### short and long syntax

### restart

### secrets

#### short and long syntax

### security_opt

### stop_grace_period

### stop_signal

### sysctls

### tmpfs

### ulimits

### userns_mode

### volumes

#### short and long syntax

#### volumes for services, swarms, and stack files

#### caching options for volume mounts (Docker Desktop for Mac)

#### domainname, hostname, ipc, mac_address, privileged, read_only, shm_size, stdin_open, tty, user, working_dir

### Specifying durations

### Specifying byte values

### Volume configuration reference

#### driver, driver_opts, external, labels, name

### Network configuration reference

#### driver, bridge, overlay, host or none, driver_opts, attachable, enable_ipv6, ipam, internal, labels, external, name

### configs configuration reference

### secrets configuration reference

### Variable substitution

### Extension fields








aliases and networks and network resolution
