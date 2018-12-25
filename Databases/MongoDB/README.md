## [MongoDB](https://www.mongodb.com/)

MongoDB is a NoSQL document database that can interpret JavaScript. It has drivers for Python, Java and C++.  

## [MongoDB Community Edition Installation](https://docs.mongodb.com/manual/installation/)

Sample installation: Linux installation, Ubuntu 18.04 Bionic  
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

1. Start Mongo deamon.  
2. Stop Mongo deamon.  
3. Restar Mongo deamon.  
4. Check Mongo log to see if Mongod is working: /var/logs/mongodb/mongod.log  
5. Open Mongo shell.  

```
sudo service mongod start  
sudo service mongod stop  
sudo service mongod restart  

mongo  
```

## [Mongo drivers](https://docs.mongodb.com/ecosystem/drivers/)

[Python driver](https://docs.mongodb.com/ecosystem/drivers/python/)  
[Java driver](http://mongodb.github.io/mongo-java-driver/?jmp=docs)  
[C++ driver](http://mongocxx.org/?jmp=docs)  

## [Mongo shell](https://docs.mongodb.com/manual/mongo/)

Mongo shell can interpret JavaScript.  
For example, you can use JavaScript to change data types or construct mapReduce functions.

```
show dbs # show all dbs
db # show current db
use _db_name # change db

show collections # show collectons in current db

db._collection.save(_document) # upsert depending on params
db._collection.insert(_document) # insert
db._collection.update(_query, _update) # update

db._collection.find(_query, _projection) # like select
db._collection.find(_query, _projection).count()
db._collection.find(_query, _projection).limit(_number) 
db._collection.find(_query, _projection).sort(_asc_desc) 
db._collection.find(_query, _projection).pretty()  
```

```
db._collection.find({}, {name: 1, type: 1}); #select all, but show only _id, name and type
db._collection.find({}, {_id:0, name: 1, type: 1}); #select all, but show only name and type, excluding _id 
```

## [Mongo object _id](https://docs.mongodb.com/manual/reference/method/ObjectId/)

```
ObjectID().getTimestamp(_id) # extract timestamp from ObjectId
```

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
db._collection.update({_id: 'mon'}, {$inc: {counter: 1}, $set: {modified: new Date()}}) # increment counter by 1 and set a new field

db._collection.update({_id: 'mon'}, {$set: {modified: []}}); # set an array field over a value
db._collection.update({_id: 'mon'}, {$inc: {counter:1}, $push: {modified: new Date()}}) # increment counter by 1 and push a timestamp to an array
db._collection.update({_id: 'mon'}, {$inc: {counter: -1}, $pop: {dateModified : 1}}) # increment counter by -1 and pop a timestamp from an array

db._collection.update({}, {$set: {cnt: 0, dateModified: []}}, {multi: true}) # set all document arrays and counters to empty and 0 respectively 
```

## [Mongo query operators](https://docs.mongodb.com/manual/reference/operator/query/)

Comparison operators:  
$gt  
$eq    
$in  
$nin  
$all  


Logical operators:  
$and  
$not  
$or  
$exists  
$type  

```
db._collection.find({_attribute: {$eq: 99}}).count()
db._collection.find({_attribute: {$gt: 10}}).count()
db._collection.find({_attribute: {$not: {$gt: 10}}}).count()
db._collection.find({_attribute: {$in: [1, 10]}}).count()
db._collection.find({_attribute: {$all: ["Human", "Knight"]}} ).count()
```

## [Mongo BSON data types](https://docs.mongodb.com/manual/reference/bson-types/#bson-types)

JavaScript parse functions:  
[parseInt()](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/parseInt)  
[parseFloat()](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/parseFloat)  

```javascript
// change data type to _parse_function's type 
db._collection.find({_attribute: {$exists: true}}).forEach(function(document) {
  document._attribute = _parse_function(document._attribute);
  db._collection.save(document);
});
```

## [Mongo cursor](https://docs.mongodb.com/manual/reference/method/js-cursor/)

```
cursor = db._collection.find({_attribute: "Wizard"}, {_attribute: 1}).sort({_attribute: -1, _id: 1})
cursor = db._collection.find({_attribute: "Wizard"}, {_attribute: 1}).sort({_attribute: -1, _id: 1}).skip(50).limit(50)
```

## [Mongo mapReduce algorithm](https://docs.mongodb.com/master/reference/command/mapReduce/)

[Visual explanation](https://docs.mongodb.com/manual/core/map-reduce/)

mapReduce algorithm maps, combines, shuffles and reduces data from N nodes into a single value.  

```
...
{
_id: ObjectId("..."),
cust_id: "abc123",
ord_date: new Date("Oct 04, 2012"),
status: 'A',
price: 25,
items: [{unit: "mmm", quantity: 5, price: 2.5},
        {unit: "nnn", quantity: 5, price: 2.5}]
}
...
```

```javascript
// map function is applied to each document in the collection
// input: a document
var map = function() {
  for (var i = 0; i < this.items.length; i++) {
    var key = this.items[i].unit;
    var value = {count: 1, quantity: this.items[i].quantity};
    emit(key, value);
  }
};
// output: {key: "mmm", value: {count: 1, quantity: 5}} and 
//         {key: "nnn", value: {count: 1, quantity: 5}} and
//         {key: "nnn", value: {count: 2, quantity: 15}

// reduce function is applied to each group of values where all members of a group share a common key
// input: values grouped by a common key
//        keyUnit: "mmm", countObjectValues: {count: 1, quantity: 5} and
//        keyUnit: "nnn", countObjectValues: [{count: 1, quantity: 5}, {count: 2, quantity: 15}]
var reduce = function(keyUnit, countObjectValues) {
  reduced_values = {count: 0, quantity: 0};

  for (var i = 0; i < countObjectValues.length; i++) {
    reduced_values.count += countObjectValues[i].count;
    reduced_values.quantity += countObjectValues[i].quantity;
  }

  return reduced_values;
};
// output: {keyUnit: "mmm", reduced_values: {count: 1, quantity: 5}} and 
//         {keyUnit: "nnn", reduced_values: {count: 3, quantity: 20}}

// finalise function is applied to each reduced value and their key
// input: reduced values and their key
//        {key: "mmm", reduced_values: {count: 1, quantity: 5}} and 
//        {key: "nnn", reduced_values: {count: 3, quantity: 20}}
var finalise = function (key, reduced_values) {
  reduced_values.average = reduced_values.quantity / reduced_values.count;
  
  return reduced_values;
};
// output: {key: "mmm", reduced_values: {count: 1, quantity: 5, average: 0.2}} and 
//         {key: "nnn", reduced_values: {count: 3, quantity: 20, average: 6.66}}

// if a collection "map_reduce_example" already exists, merge it instead of overwritting
// as input into map, consider only those that satisfy the condition "$gt: new Date('01/01/2012')"
db.orders.mapReduce(
  map,
  reduce,
  {out: {merge: "map_reduce_example"},
   query: {ord_date: {$gt: new Date('01/01/2012')}},
   finalize: finalise}
)
```

## [Mongo aggregation pipeline](https://docs.mongodb.com/master/core/aggregation-pipeline/)

An advanced high quality data aggregation pipeline, much better then mapReduce.  
However, unlike mapReduce, it cannot execute any function.  

## [Mongo indexes](https://docs.mongodb.com/master/indexes/)

[Single Filed Index](https://docs.mongodb.com/master/core/index-single/)  

```
db._collection.createIndex({_attribute: 1}) # 1 == ASCENDING, -1 == DESCENDING
```

[Find out if your query uses an index](https://docs.mongodb.com/master/tutorial/analyze-query-plan/)

```
db._collection.find({_attribute: {$gte: 100}}).explain("executionStats")
// if COLLSCAN exists in winningPlan, no index is used
// if IXSCAN exists in winningPlan, an index is used
```

## [Mongo replication](https://docs.mongodb.com/master/replication/)

TODO

## [Mongo sharding](https://docs.mongodb.com/master/sharding/)

TODO

## [mongoimport](https://docs.mongodb.com/manual/reference/program/mongoimport/)

Can import data in extended JSON, CSV or TSC format, UTF-8 encoding.  
Use from the command line.  

```
mongoimport --db _db_name --collection _collection_name --file _file_name
```
