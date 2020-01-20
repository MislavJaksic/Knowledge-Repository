## [Harbor Documentation](https://goharbor.io/docs/)

Harbour is a registry that stores, signs and scans content.   
Harbour adds security, identity and management.  
Harbour manages users, access control and activity auditing.  
Harbour replicates images between registries.  
Having a registry closer to the build and run environment improves the image transfer efficiency.  

### Features

* Cloud native registry: supports images and Helm charts
* Role based access control (RBAC): users and repositories are organized via `projects`
* Policy based replication: images and charts can be replicated or synchronized between registry instances
* Vulnerability Scanning: scans images regularly and warns users of vulnerabilities.
* LDAP/AD: integrates with LDAP/AD for user authentication and management
* OpenID Connect (OIDC): authenticate users with an authorization server or identity provider. Supports single sign-on
* Image deletion and garbage collection: images can be deleted and recycled
* Notary: image authenticity
* Graphical user portal: users can browse, search repositories and manage projects
* Auditing: all the operations to the repositories are tracked
* RESTful API: RESTful APIs for admin operations with a Swagger UI
* Deployment: online, offline and Helm chart installation
