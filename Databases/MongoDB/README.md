## [MongoDB](https://www.mongodb.com/)

## [Linux installation, Ubuntu 18.04 Bionic](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/#install-mongodb-community-edition-using-deb-packages)

1. Import a public key.  
2. Create a Mongo list file.  
3. Update the apt package manager.  
4. Install MongoDB packages.  
5. It is suggested you also pin the MongoDB package version to prevent accidental upgrades.

```
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 9DA31620334BD75D9DCB49F368818C72E52529D4
echo "deb [ arch=amd64 ] https://repo.mongodb.org/apt/ubuntu bionic/mongodb-org/4.0 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-4.0.list
sudo apt-get update
sudo apt-get install -y mongodb-org

echo "mongodb-org hold" | sudo dpkg --set-selections
echo "mongodb-org-server hold" | sudo dpkg --set-selections
echo "mongodb-org-shell hold" | sudo dpkg --set-selections
echo "mongodb-org-mongos hold" | sudo dpkg --set-selections
echo "mongodb-org-tools hold" | sudo dpkg --set-selections
```

1. Start MongoDB.  
2. Stop MongoDB.  
3. Restar MongoDB.  
4. Check Mongo log to see if Mongod is working: /var/logs/mongodb/mongod.log  
5. Open Mongo shell.  

```
sudo service mongod start  
sudo service mongod stop  
sudo service mongod restart  

mongo  
```

## [Mongo drivers](https://docs.mongodb.com/ecosystem/drivers/)

[Python drivers](https://docs.mongodb.com/ecosystem/drivers/python/)  

## [Mongo shell](https://docs.mongodb.com/manual/mongo/)

Mongo shell can interpret JavaScript.  
For example, you can use JavaScript to change data types or construct mapReduce funsions.

```
show dbs # show all dbs
db # show current db
use _db_name # change db

show collections  # show collectons in current db

db._collection.save(_document) # upsert depending on params
db._collection.insert(_document) # insert
db._collection.update(_query, _update) # update

db._collection.find(_query, _projection) # like select
db._collection.find(_query, _projection).count() 
db._collection.find(_query, _projection).pretty() 
 
ObjectID().getTimestamp(_id) # extract timestamp from id
```

```
db._collection.find({}, {name: 1, type: 1}); #select all, but show only _id, name and type
db._collection.find({}, {_id:0, name: 1, type: 1}); #select all, but show only name and type, excluding _id 
```

## [Mongo object _id](https://docs.mongodb.com/manual/reference/method/ObjectId/)

TODO

## [Mongo update operators](https://docs.mongodb.com/manual/reference/operator/update/)

Fields:  
$currentDate  
$inc  
$rename  
$set  
$unset  

Array operators:  
$push  
$pop  
$pull
$addToSet  

```
db._collection.insert({_id: 'mon', counter: 0})

db._collection.update({_id: 'mon'}, {$inc: {counter: 1}}) # increment counter by 1
db._collection.update({_id: 'mon'}, {$inc: {counter: 1}, $set: {modified: new Date()}}) # increment counter by 1 and add a new field
db._collection.update({_id: 'mon'}, {$set: {modified: []}}); # add an array instead of value
db._collection.update({_id: 'mon'}, {$inc: {counter:1}, $push: {modified: new Date()}}) # increment counter by 1 and add a timestamp to an array
db._collection.update({_id: 'mon'}, {$inc: {counter: -1}, $pop: {dateModified : 1}}) # increment counter by -1 and pop a timestamp from an array
db._collection.update({}, {$set: {cnt: 0, dateModified: []}}, {multi: true}) # set all document arrays and counters to empty and 0 respectively 
```

## [Mongo query operators](https://docs.mongodb.com/manual/reference/operator/query/)

Comparison operators:  
$gt  
$eq  
$not  
$in  
$nin  
$all  


Logical operators:  

```
db._collection.find({_attribute: {$eq: 99}}).count()
db._collection.find({_attribute: {$gt: 10}}).count()
db._collection.find({_attribute: {$not: {$gt: 10}}}).count()
db._collection.find({_attribute: {$in: [1, 10]}}).count()
db._collection.find({_attribute: {$all: ["Human", "Knight"]}} ).count()
```

## [Mongo BSON data types](https://docs.mongodb.com/manual/reference/bson-types/#bson-types)

JavaScript parse functions:  
parseInt()  
parseFloat()  

```javascript
// change data type to _parse_function's type 
db._collection.find({_attribute: {$exists: true}}).forEach(function(document) {
  document._attribute = _parse_function(document._attribute);
  db._collection.save(document);
});
```

## [Mongo cursor](https://docs.mongodb.com/manual/reference/method/js-cursor/)

```
db._collection.find({_attribute:"Wizard"}, {_attribute: 1}).sort({_attribute: -1, _id: 1})
db._collection.find({_attribute:"Wizard"}, {_attribute: 1}).sort({_attribute: -1, _id: 1}).skip(50).limit(50)
```

## [Mongo mapReduce algorithm](https://docs.mongodb.com/master/reference/command/mapReduce/)

mapReduce algorithm maps, combines, shuffles and reduces data from N nodes into a single value.  

```
{
_id: ObjectId("..."),
cust_id: "abc123",
ord_date: new Date("Oct 04, 2012"),
status: 'A',
price: 25,
items: [{unit: "mmm", quantity: 5, price: 2.5},
        {unit: "nnn", quantity: 5, price: 2.5}]
}
```

```javascript
// map (not reduce!) function
// emits: {key: "mmm", value: {count: 1, quantity: 5}} and 
//        {key: "nnn", value: {count: 1, quantity: 5}}
var map = function() {
  for (var i = 0; i < this.items.length; i++) {
    var key = this.items[i].unit;
    var value = {count: 1, quantity: this.items[i].quantity};
    emit(key, value);
  }
};

// reduce (not map!) function
// received: keyUnit: ["mmm", "nnn"]
//           countObjectValues: [{count: 1, quantity: 5}, {count: 1, quantity: 5}]
var reduce = function(keyUnit, countObjectValues) {
  reduced_values = {count: 0, quantity: 0};

  for (var i = 0; i < countObjectValues.length; i++) {
    reduced_values.count += countObjectValues[i].count;
    reduced_values.quantity += countObjectValues[i].quantity;
  }

  return reduced_values;
};

// finalise (not map or reduce!) function
var finalise = function (key, reduced_values) {
  reduced_values.average = reduced_values.quantity / reduced_values.count;
  
  return reduced_values;
};

// ecexute functions
db.orders.mapReduce(
  map,
  reduce,
  {out: {merge: "map_reduce_example"},
   query: {ord_date: {$gt: new Date('01/01/2012')}},
   finalize: finalise
  }
)
```

## [Mongo aggregation pipeline](https://docs.mongodb.com/master/core/aggregation-pipeline/)

An advanced high quality data aggregation pipeline, much better then mapReduce.  
However, unlike mapReduce, it doesen't have unlimited capabilities.  

## [Mongo indexes](https://docs.mongodb.com/master/indexes/)

TODO

## [Mongo replication](https://docs.mongodb.com/master/replication/)

TODO

## [Mongo sharding](https://docs.mongodb.com/master/sharding/)

TODO

## [mongoimport](https://docs.mongodb.com/manual/reference/program/mongoimport/)

Can import data in extended JSON, CSV or TSC format, UTF-8 encoding.  
Use from the command line.  
For example: mongoimport --db _db_name --collection _collection_name --file _file_name
