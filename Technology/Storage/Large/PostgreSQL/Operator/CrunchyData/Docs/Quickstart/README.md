## [Quickstart](https://access.crunchydata.com/documentation/postgres-operator/4.2.2/quickstart/)

### Step 1: Prerequisites

`Kubernetes` / `OpenShift`:
* you are able to create a `ClusterRole`
* `Kubernetes` version should be >1.13, `OpenShift` version >3.11
* has `PersistentVolume`s

You should also have:
* `kubectl` or `oc` that can access the cluster  
* `ansible` >2.5
* `git`
* `gcloud`, if using the `Google Kubernetes Engine`

### Step 2: Configuration
```
$: git clone https://github.com/CrunchyData/postgres-operator.git
$: cd postgres-operator
$: git checkout v4.2.2 # you can substitute this for the version that you want to install
$: cd ansible
```

#### Kubernetes

```
# ...
kubernetes_context='Kubernetes-Cluster-Context'  # $: kubectl config current-context
# ...
pgo_admin_password='Super-Secret-Password'  # remember it
# ...
service_type='NodePort'  # ClusterIP, NodePort, ...
# ...
backrest_storage='ocistorage'  # pick or create a storage solution
backup_storage='ocistorage'
primary_storage='ocistorage'
replica_storage='ocistorage'
# ...
storage10_name='ocistorage'  # pick or create a storage solution
storage10_access_mode='ReadWriteOnce'
storage10_size='50Gi'
storage10_type='dynamic'
storage10_class='oci'
storage10_fs_group=26
```

#### OpenShift

TODO

#### Google Kubernetes Engine (GKE)

TODO

### Step 3: Installation

```
$: pwd  # -> /.../postgres-operator/ansible
$: ansible-playbook -i inventory --tags=install main.yml
```

Setup `pgo` command line interface:
```
$: export PGOUSER="${HOME?}/.pgo/pgo/pgouser"
$: export PGO_CA_CERT="${HOME?}/.pgo/pgo/client.crt"
$: export PGO_CLIENT_CERT="${HOME?}/.pgo/pgo/client.crt"
$: export PGO_CLIENT_KEY="${HOME?}/.pgo/pgo/client.pem"
$: export PGO_APISERVER_URL='https://127.0.0.1:8443'
$: export PGO_NAMESPACE=pgouser1
```

### Step 4: Verification

```
$: kubectl -n pgo get deployments
$: kubectl -n pgo get pods
```

```
$: kubectl -n pgo port-forward svc/postgres-operator 8443:8443
$: pgo version !!!FAILS!!!
```

!!!ABANDONED!!!
TODO

If successful, you should see output similar to this:

pgo client version 4.2.2
pgo-apiserver version 4.2.2

Step 5: Have Some Fun - Create a PostgreSQL Cluster

The quickstart installation method creates two namespaces that you can deploy your PostgreSQL clusters into called pgouser1 and pgouser2. Let’s create a new PostgreSQL cluster in pgouser1:

pgo create cluster -n pgouser1 hippo

Alternatively, because we set the PGO_NAMESPACE environmental variable in our .bashrc file, we could omit the -n flag from the pgo create cluster command and just run this:

pgo create cluster hippo

Even with PGO_NAMESPACE set, you can always overwrite which namespace to use by setting the -n flag for the specific command. For explicitness, we will continue to use the -n flag in the remaining examples of this quickstart.

If your cluster creation command executed successfully, you should see output similar to this:

created Pgcluster hippo
workflow id 1cd0d225-7cd4-4044-b269-aa7bedae219b

This will create a PostgreSQL cluster named hippo. It may take a few moments for the cluster to be provisioned. You can see the status of this cluster using the pgo test command:

pgo test -n pgouser1 hippo

When everything is up and running, you should see output similar to this:

cluster : hippo
	Services
		primary (10.97.140.113:5432): UP
	Instances
		primary (hippo-7b64747476-6dr4h): UP

The pgo test command provides you the basic information you need to connect to your PostgreSQL cluster from within your Kubernetes environment. For more detailed information, you can use pgo show cluster -n pgouser1 hippo.
