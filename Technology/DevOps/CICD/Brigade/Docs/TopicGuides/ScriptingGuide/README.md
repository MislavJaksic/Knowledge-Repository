## [Scripting Guide](https://docs.brigade.sh/topics/scripting/)

Explains how to create `brigade.js` files.  
See Research.  

### Brigade Scripts, Projects, and Repositories

#### Groups

`brigade-12.js`:
* execute `Group`s of `Job`s in sequence
* execute `Job`s in each `Group`s in parallel

#### Storing Data with Caches and Shared Space

`brigade-15.js`:
* share files between `Job`s using `PVC`
* 50 megabytes of storage per build (override in project configuration)

`brigade-16.js`:
* cache jobs
* 5 megabytes of storage (override with `job.cache.size`)
