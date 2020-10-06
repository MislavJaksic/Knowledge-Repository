## Getting Started

### Who is This Guide For?

For beginners who read the Overview chapter.  

### Terminology Used in This Guide

`FlowFile`: made of `Content` and `Attribute` key-value pairs  
`Processor`: creates, sends, receives, transforms, routes, splits, merges, and process `FlowFile`s  

### Downloading and Installing NiFi

TODO

### Starting NiFi

TODO

### I Started NiFi. Now What?

```
http://localhost:8080/nifi
```

UI components:
* Global Menu
* Components Toolbar
* Status Bar
* Operate Palette

#### Adding a Processor

Drag and drop the `Processor` icon.  
Assign `Tag` keywords and a name.  

#### Configuring a Processor

Right click and select `Configure`.  

`Properties` are `Processor` dependent.  
`Properties` in bold are required.  

#### Connecting Processors

`Processor`s have `Relationship`s to which they send data.  
Drag and drop the `Processor`'s `Connection` icon over another `Processor`.  

You can make the data expire, set a backpressure threshold and `Prioritizer`s that sort data in the queue.  

At the end of the dataflow, you can auto-terminate the data.  

#### Starting and Stopping Processors

Select and press `Start`.  
Until `Stopped` you can only view the `Processor`'s configuration.  

#### Getting More Info for a Processor

Right click and select `Usage`.  

#### Other Components

Others:
* Input and Output Ports
* Funnels
* Process Groups
* Remote Process Groups

### What Processors are Available

TODO

### Working With Attributes

TODO

### Custom Properties Within Expression Language

TODO

### Working With Templates

TODO

### Monitoring NiFi

TODO

### Data Provenance

TODO
