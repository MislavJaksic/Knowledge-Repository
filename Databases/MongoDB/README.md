## [MongoDB](https://www.mongodb.com/)

## [Linux installation, Ubuntu 18.04 Bionic](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/#install-mongodb-community-edition-using-deb-packages)

Import a public key with the command: sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 9DA31620334BD75D9DCB49F368818C72E52529D4  
Create a Mongo list file with the command: echo "deb [ arch=amd64 ] https://repo.mongodb.org/apt/ubuntu bionic/mongodb-org/4.0 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-4.0.list  
Update the apt package system with: sudo apt-get update  
Install MongoDB packages using: sudo apt-get install -y mongodb-org  
It is suggested to also pin the MongoDB package version to prevent accidental upgrades.  

Start MongoDB: sudo service mongod start  
Stop MongoDB: sudo service mongod stop  
Restar MongoDB: sudo service mongod restart  
Mongo log location: /var/logs/mongodb/mongod.log  
Open Mongo shell: mongo  

## [Mongo drivers](https://docs.mongodb.com/ecosystem/drivers/)

[Python drivers](https://docs.mongodb.com/ecosystem/drivers/python/)  

## [Mongo shell](https://docs.mongodb.com/manual/mongo/)

show dbs  
db  
use _db_name  
can interpret JS code  
show collections  
db._collection_name.save(_collection_data)  
db._collection_name.insert(_collection_data)  
db._collection_name.find()  
ObjectID().getTimestamp(_id)  

## [Mongo object _id](https://docs.mongodb.com/manual/reference/method/ObjectId/)

