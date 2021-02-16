## [User Guide](https://github.com/zalando/postgres-operator/blob/master/docs/user.md#connect-to-postgresql)

### Create a manifest for a new PostgreSQL cluster

See [Quickstart](../Quickstart).  

### Connect to PostgreSQL

```
$: export PGMASTER=$(kubectl get pods -o jsonpath={.items..metadata.name} -l application=spilo,cluster-name=Team-Name-Postgresql-Cluster-Name,spilo-role=master -n K8s-Postgres-Namespace)

$: kubectl port-forward $PGMASTER 6432:5432 -n K8s-Postgres-Namespace
```

```
$: export PGPASSWORD=$(kubectl get secret postgres.Team-Name-Postgresql-Cluster-Name.credentials.postgresql.acid.zalan.do -o 'jsonpath={.data.password}' | base64 -d)
export PGSSLMODE=require
$: psql -U postgres -p 6432
```

### Defining database roles in the operator

TODO
...
