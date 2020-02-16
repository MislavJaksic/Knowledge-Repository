## [Docs](https://concourse-ci.org/docs.html)

`Pipeline` is are built around a `Resource`.  
`Pipeline` represents a dependency flow, like a distributed `Makefile`.  
`Resource` represents a state.  
`Resource` can be of type `git`, `s3`,`time`, ...  
`Job` interact with a `Resource`.   
`Job` is a sequence of `get`, `put` and `task` steps to execute.   
Steps determine the `Job`'s inputs and outputs.   


Everything runs in a container.   
Workers are not modified to install build tools.  
