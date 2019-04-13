# RESTful Web Services

Written by Leonard Richardson and Sam Ruby. The book talks about RESTful, Resource-Oriented web services.  

What follows is a brief summary of their book.  



## Chapter 1: Programmable Web

URI is a URL.  
Type a URI into a browser and you get a HTML page.  
Web browser is a gateway to programs and data on the human web. No need for installation.  

The programmable web is just like the human web, but it serves XML instead of HTML documents.

A browser shows the document to a human.  
A service has to determine the meaning of the document as well.  

### Kinds of Things on the Programmable Web

The programmable web is based on HTTP and XML.  

Classify services not by technology (URI, SOAP, XML_RRPS, ...) but by architecture.  

### HTTP: Documents in Envelopes

HTTP, a document protocol. It puts a document into an envelope.  
HTTP is strict about the look of an envelope, not about its contents.  

HTTP GET REQUEST for "http://www.oreilly.com/index.html":
```
GET /index.html HTTP/1.1
Host: www.oreilly.com
User-Agent: Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.7.12)...
Accept: text/xml,application/xml,application/xhtml+xml,text/html;q=0.9,...
Accept-Language: us,en;q=0.5
Accept-Encoding: gzip,deflate
Accept-Charset: ISO-8859-15,utf-8;q=0.7,*;q=0.7
Keep-Alive: 300
Connection: keep-alive

[HTTP Method] [Path] [Version]
[Request Header: Value]
...
[Request Header: Value]
[Entity-Body]
```

HTTP GET RESPONSE from http://www.oreilly.com/index.html:  
```
HTTP/1.1 200 OK
Date: Fri, 17 Nov 2006 15:36:32 GMT
Server: Apache
Last-Modified: Fri, 17 Nov 2006 09:05:32 GMT
Etag: "7359b7-a7fa-455d8264
Accept-Ranges: bytes
Content-Length: 43302
Content-Type: text/html
X-Cache: MISS from www.oreilly.com
Keep-Alive: timeout=15, max=1000
Connection: Keep-Alive
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
...
<title>oreilly.com -- Welcome to O'Reilly Media, Inc.</title>
...

[Version] [Response Code]
[Response Header: Value]
...
[Response Header: Value]
[Entity-Body]
```

```
HTTP Method      -> how the server should process the envelope
Response Code    -> request consequences
Path             -> address; portion of the URI after the hostname
Request Headers  -> metadata
Response Headers -> metadata
Entity-Body      -> document
```

Response header "Content-Type" determines the media type in "Entity-Body".
```
text/html       -> text documents
application/xml -> structured text
image/jpeg      -> images 
```

### Method Information

Method info tells the server what the client wants to do.  

HTTP methods:  
```
GET
HEAD
PUT
DELETE
POST
```

#### XPath primer

XPath is used to slice XML.  
XPath is read from right to left.  

Example, //photo:  
* photo -> "find every photo tag"
* //    -> "no matter where it is"

### Scoping information

Scoping info tells the server on which data the client wants to operate.  

Scope can be in:  
```
The URI
On the path
In Entity-Body
```

### Competing Architectures

RESTful, RPC and REST RPC hybrids.  

RESTful services that look like the Web are resource oriented.  

RESTful:  
```
Method info -> in the HTTP method
Scope info  -> in the URI
```

```
TODO
- RPC-Style Architectures
  - RPC-style web service accepts an envelope full of data from its client, and sends a similar envelope back. The
method and the scoping information are kept inside the envelope or as headers.
  - Every RPC-style service defines a brand new vocabulary.

- REST-RPC Hybrid Architectures
  - Hybrids that are those services that behave like RESTful, but are designed to be RPC-style services.
  - They often use HTTP as a convenient envelope format.

Technologies on the programmable web:
- HTTP: a request to a RESTful web service puts the method information in the HTTP method and the scoping
information in the URI. RPC-style web services tend to ignore the HTTP method, looking for method and scoping
information somewhere else.

- URI: RESTful, resource-oriented service exposes a URI for every piece of data on which the client might want to
operate. A REST-RPC hybrid exposes a URI for every operation the client might perform: one URI to fetch a piece of
data, a different URI to delete that same data. An RPC-style service exposes one URI for every processes capable of
handling Remote Procedure Calls (RPC). Most often, there is only one such URI, the endpoint.
  
- XML-RPC: data structure format for representing function calls and their return values.

- SOAP: envelope format like HTTP on top of HTTP that uses XML-based envelope format. SOAP is a way of putting data
in the envelope.

- WS-*: define XML headers for SOAP envelope

- WSDL: Web Service Description Language, XML vocabulary used to describe SOAP-based web services. A client can load
a WSDL file and know exactly which RPC-style methods it can call, what arguments those methods expect, and which
data types they return.

- WADL: Web Application Description Language, XML vocabulary used to describe RESTful web services. As with WSDL, a
generic client can load a WADL file and be immediately equipped to access the full functionality of the
corresponding web service.
```



## Chapter 2: Writing Web Service Clients

### Web Services Are Web Sites

Web service request consists of:
1) Coming up with request data
2) Creating a request
3) Parsing a response

The process is abstracted by using wrappers.  

### Making the Request: HTTP Libraries

Must have features:  
```
HTTPS, SSL
GET, HEAD, POST, PUT, DELETE
Custom Entity-Body
Custom HTTP Header
Access to Entity-Body, Response Code and Headers
HTTP proxy communication
```

Nice to have features:  
```
OPTIONS, TRACE, MOVE
Data compression
Cache
Authentication
Follow HTTP redirects
HTTP cookie strings
```

Good HTTP libraries:
```
CLI        -> curl
C#         -> System.Web.HTTPWebRequest
Java       -> HttpClient
Python     -> httplib2
JavaScript -> XMLHttpRequest
Ruby       -> rest-open-uri and net/http
PHP        -> libcurl
Lisp       -> simple-http
```

### Processing the Response: XML Parsers

Three kinds of XML parsers and strategies: 
* tree style, document, DOM parsers
* event style, stream, "pull" parsers
* event style, stream, SAX parsers

DOM parser:  
```
Simple, tree, data structure parser
Use DOM, XPath, CSS selectors
Can access any elements many times
Must load the whole document into memory
```

Pull parser:  
```
XML to event stream
Get events one by one and act on most
Memory efficient
Consumes events and must parse again for access
XML must we well formed
```

SAX parser:  
```
XML to event stream
Get events one by one and act on only a few
Memory efficient
Consumes events and must parse again for access
XML must we well formed
```

Good XML parsers:
```
C#         -> System.Xml.XmlReader
Java       -> javax.xml, Xerces, or XMLPull
Python     -> ElementTree
JavaScript -> responseXML
Ruby       -> REXML
```

### JSON Parsers: Handling Serialized Data

JSON as an alternative to XML.  
Recommends against using JSON.  

### Clients Made Easy with WADL

Web Application Description Language (WADL).  
Abstracts different REST clients.  



## Chapter 3: What makes RESTful services different?

```
TODO
### Example: Object-Oriented Design of S3


Two well known RESTful services are: the Atom Publishing Protocol (APP) and Amazon’s Simple Storage Service (S3).

S3:
- made to be accessed programmatically
- has a concept of buckets and objects. Object is a named piece of data with metadata. Bucket is a named container
for objects. Buckets cannot be nested.
- objects: has a reference to a bucket, data that is stored (value), name and a set of key value pairs of metadata.
- RESTful services expose standard HTTP objects called resources which respond to standard HTTP requests
- there are three kinds of resources: list of buckets, a particular bucket and a particular object inside a bucket
- every resource exposes the same kind of interface and works the same way
  - get value with GET request, get metadata with HEAD request, create a bucket with PUT request, ...


| Resource URI | GET | HEAD | PUT | DELETE |
| -- | -- | -- | -- | -- |
| The bucket list (/) | List your buckets | - | - | - |
| A bucket (/{bucket}) | List the bucket’s objects | - | Create the bucket | Delete the bucket |
| An object (/{bucket}/{object}) | Get the object’s value and metadata | Get the object’s metadata | Set the object’s value and metadata | Delete the object |

In a well designed RESTful service, everything does what it says. No need to invent a language.

HTTP response codes: RESTful services use HTTP response codes. They tell the client if everything went well of it
an error occurred.

The author writes a client for Amazon's S3 in Ruby.

Instead of writing a custom client for every service you could either use WADL to describe a service or use Ruby's
ActiveResource that makes it easy to write clients for some kinds of web services.

The author wrote a Python client that does the same as the Ruby one.
```



## Chapter 4: Resource Oriented Architecture (ROA)

RESTful architecture: Resource Oriented Architecture (ROA).  
It says how to turn a problem into URIs, HTTP and XML.  

### Resource Oriented Architecture

Turns requirements into resources.  
An architecture among many.  

### What’s a Resource?

A construct that deserves to have an address.  

### URIs

URI is the address and name of a resource.  

URIs should be predictable. They should have an intuitive structure.  

A resource can have multiple URIs that differ in intention.  
A URI can point to only one resource.  

### Addressability

Addressable applications exposes a URI for every resource they can serve.  

Example: http://www.google.com/search?q=jellyfish

### Statelessness

Statelessness means that every HTTP request happens in complete isolation.  
Never remember previous requests.  
Send all necessary information with each request.  
No temporal coupling.  

Server states must have a URI.  
Example: http://www.google.com/search?q=jellyfish&start=10

Allows scaling.  
Allows caching.  

### Application State Versus Resource State

Application state is on the client.  
The client makes it known to the server in every request.  

Resource state is on the server.  
It is the same for every client.  

Cookies are a huge problem.  
Counting the number of client requests is a huge problem.  

### Representations

Each resource is represented in at least one way.  

### Deciding Between Representations

Give each resource representation its own URI.  
Alternatively, specify a Platonic URI, which points to a default representation.  

### Connectedness and Links

```
"Hypermedia as the engine of application state" -> state in links
```

Send links to "nearby" resources with the representation itself.  

Links are "levers of state".  

### Uniform Interface

Use HTTP methods.  

GET: fetch; response Entity-Body has a representation  
DELETE: delete; any response  
PUT: create or modify; request Entity-Body has a resource  

HEAD: fetch only metadata  
OPTIONS: check supported HTTP methods; response has an "Allow" header  

POST: create subordinate resource or append info to existing representation  
POST is defined in RFC 2616.  

PUT vs POST: who decides which URI is assigned to a resource?
PUT -> client decides
POST -> server decides

#### Overloaded POST

When POST is used to provide a block of data and asks a block of data in return.  
POST is mimicking many different non-HTTP methods.  
Don't do it.  

However, sometimes overloading is unavoidable.

### Safety

GET and HEAD are safe.  
They never change the server state.  
They cause no side effects (for which the client is responsible or cares about).  

### Idempotence

GET, HEAD, PUT and DELETE are idempotent.  
Their effect is the same if you call them once or many times.  

#### Why safety and idempotence matter

They make HTTP request reliable even over an unreliable network.  

### Overall

ROA concepts are:
```
Resources
URIs
Representations
Links between resources
```

ROA properties are:
```
Addressability
Statelessness
Connectedness
Uniform Interface
```



## Chapter 5: Designing Read Only ROA

An example of a read only RESTful service.  

RESTful services should look like web sites to humans.  

### Resource Design

Break up the problem top down.  
Each noun is a class.  
Turn verbs into nouns.  

Example: "Reader subscribes to a Column."  
```
Reader
Subscription -> represents the relationship between Reader and Column
Column
```

Don't add functions to a class, add resources.  

### Turning Requirements Into Read-Only Resources

```
Identify the data
Split the data into resources
For each resource type:
  Name them with URIs
  Expose a subset of the uniform interface
  Design the representation(s) accepted from the client
  Design the representation(s) served to the client
  Integrate this resource into existing resources, using hypermedia links and forms
  Consider the typical course of events: what’s supposed to happen?
  Consider error conditions: what might go wrong?
```

### Figure Out the Data Set

All 2D maps, addressable by longitude and latitude.  
A map is anchored by a coordinate.  
Places are points of interest. They have a name.  

You may need to repeat this step many times.  

### Split the Data Set into Resources

A resource is anything that can have a URI.  

Three resource types:
```
Unique resources       -> homepage, admin
Object resources       -> any class object
Algorithmic resources  -> resources as a result of an operation
```

In the example, resources are:
* list of planets
* list of places that match a criteria
* place on a planet, identified by a name
* geographic points on the planet
* map of a planet, centered around a point

Expose data and algorithms through resources.  
Think about action results rather then actions.  

### Name the Resources

URI design:  
```
Encode hierarchy into path variables
Put punctuations if there is no hierarchy
Query variables imply inputs
```

Much harder then you think. Use a pen and paper.  

### Encode Hierarchy into Path Variables

Path variables hierarchically organise scoping information.  

Example: http://maps.example.com/Earth/USA/Mount%20Rushmore

### No Hierarchy? Use Commas or Semicolons

Scoping info with no hierarchy is separated by a colon or semicolon.  
```
Colon     -> order is important
Semicolon -> order doesn't matter
```

Example: http://maps.example.com/Earth/24.9195,17.821
Example: http://colour.blender.com/color-blends/red;blue

### Algorithmic Resource? Use Query Variables

Use query variables for algorithmic resources.  

Example: http://maps.example.com/Earth/Indonesia?show=oil+tankers&show=container+ships

### Design Your Representations

Send the representation of the state of a resource.  

Provide links to nearby resources, "levers of state".  

"Nearby" can mean:  
```
Pagination, next
Possible new application state
Resource state
...
```

Provide links to resource state, GET, PUT, HEAD and so on.  

### Link the Resources to Each Other

You can use HTML forms to lead to other resources.  

### The HTTP Response

Representations go into Entity-Body.  

Response code signals what happened.  

Use headers if you must.  

#### Conditional HTTP GET

Only returns the representation if the data has changed.  
Look it up in Chapter 8.  

Response headers:
```
Last-Modified
ETag
```

Request headers:
```
If-Modified-Since
If-None-Match
```

### What Might Go Wrong?

Think of the responses if a failure occurs.  

Response codes:  
```
200 -> OK
304 -> Not Modified
404 -> Not Found
303 -> See Other
400 -> Bad Request
503 -> Service Unavailable
500 -> Internal Server Error
```

#### Examples of responses

List of planets:  
```xhtml
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
  "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <title>Planet List</title>
</head>
<body>
<ul class="planets">
  <li><a href="/Earth">Earth</a></li>
  <li><a href="/Venus">Venus</a></li>
  ...
</ul>
</body>
</html>
```

Maps and points on maps:  
```xhtml
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
  "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <title>Road Map of Earth</title>
</head>
<body>
...
<img class="map" src="/road.2/Earth/images/37.0,-95.png" alt="Map tile"/>
...
<a class="map_nav" href="46.0518,-95.8">North</a>
<a class="map_nav" href="41.3776,-89.7698">Northeast</a>
<a class="map_nav" href="36.4642,-84.5187">East</a>
<a class="map_nav" href="32.3513,-90.4459">Southeast</a>
...
<a class="zoom_in" href="/road.1/Earth/37.0;-95.8">Zoom out</a>
<a class="zoom_out" href="/road.3/Earth/37.0;-95.8">Zoom in</a>
...
</body>
</html>
```

Planets and other places:  
```xhtml
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
  "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><title>Earth</title></head>
<body>
  <dl class="place">
    <dt>name</dt> <dd>Earth</dd>
    <dt>maps</dt>
      <dd>
        <ul class="maps">
          <li><a class="map" href="/road/Earth">Road</a></li>
          <li><a class="map" href="/satellite/Earth">Satellite</a>
          ...
        </ul>
      </dd>
<dt>type</dt> <dd>planet</dd>
<dt>description</dt>
  <dd>
  Third planet from Sol. Inhabited by bipeds so amazingly primitive
  that they still think digital watches are a pretty neat idea.
  </dd>
</dl>
</body>
</html>
```

Lists of search results:  
```xhtml
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
  "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><title>Search results: "Springfield"</title></head>
<body>
<p>
  Places matching <span class="searchterm">Springfield</span>
  in or around
  <a class="place" href="/Earth/USA">the United States of America</a>:
</p>
<ul>
  <li>
    <a class="place" href="/Earth/USA/IL/Springfield">Springfield, IL</a>
  </li>
  <li>
    <a class="place" href="/Earth/USA/MA/Springfield">Springfield, MA</a>
  </li>
  <li>
    <a class="place" href="/Earth/USA/MO/Springfield">Springfield, MO</a>
  </li>
  ...
</body>
</html>     
```

Link resources to each other with HTML forms:  
```xhtml
<form id="searchPlace" method="get" action="">
  <p>
    Show places, features, or businesses:
  <input id="term" repeat="template" name="show" />
  <input class="submit" />
  </p>
</form></screen>
```



Chapter 6: Designing Read/Write Resource-Oriented Services

TODO

The imaginary web service should be expended with the functionality to let 
clients store their maps.

User accounts as resources. If they weren't, overloaded POST would have to be 
used to supply a HTML form to a web application. 
The benefit is that user account can now be created automatically and accessed 
thought a uniform interface.

Authentication is the problem of tying a request to a user. 

Authorization is the problem of determining which requests to let through for a 
given user.

HTTP header called "Authorization" will be filled with credentials, the server 
will then check it.

Kinds of authentication: HTTP Basic, HTTP Digest, and WSSE (or a custom solution).

To give users privacy, encrypt each HTTP transaction over SSL.

Using HTTPS instead of HTTP prevents other computers from eavesdropping.

How do you know your browser will send your password to the website to which 
you are logging in and not to some other secret website? Don't trust your browser
so blindly.

Procedure for turning requirements into read/write resources:
- Figure out the data set
- Split the data set into resources
  For each kind of resource:
  - Name the resources with URIs
  - Expose a subset of the uniform interface
  - Design the representation(s) accepted from the client
  - Design the representation(s) served to the client
  - Integrate this resource into existing resources, using hypermedia links and 
forms
  - Consider the typical course of events: what’s supposed to happen?
  - Consider error conditions: what might go wrong?

Figure out the data set: user account is made up of a name and password.

Split the data set into resources: each account is a resource.

Name the resources with URIs: https://maps.example.com/user/{user-name}.

Expose a subset of the uniform interface: if you ever wish there were more HTTP 
methods, go back to step two and create more resources.
Observation one: clients will be creating this type of resources.
Observation two: clients are in change of naming the URI.
Client will send a PUT request to the account's URI. Client will be able to 
modify their password, but not their username, client can delete the account, 
client can ask for the representation (except for the password).

Design the representation(s) accepted from the client: specify how the user 
creates an account. Account username will be in the URI and the password in the 
form encoding, CGI escaping representation as a key value pair. To change the 
password is the same as creating the account in the first place. To change the 
password, the client needs Authorization. 

Design the Representation(s) to Be Served to the Client: client will use a GET 
request. The user account information will be send in XHTML format. If the user 
GETs another's account, it will be sent a different XHTML.

Link This Resource to Existing Resources: add "authenticated" message to the 
representation to every resource which is a hypermedia that shows the client how
to retrieve data about its user account. The home page should include a 
hypermedia link to how a user can create an account.

What’s supposed to happen: a PUT request will create a new user if one doesn't 
exist and respond with code 201 and send back a response with Location header 
containing the URI of the account. If the account already exists, the password 
is modified and the code 200 is sent back. All other HTTP methods, GET, DELETE, 
work as intended.

What Might Go Wrong?: if the client sends a representation in the wrong format, 
send the code 415. If the client sends no representation or a very poor one, 
send back the code 400. If the presentation is illegal, such as the path where 
you want to store data is inconsistent or the password is empty, then send back 
either 400 or 409 code. If the client's credentials are wrong, return code 401. 
If the problem is unspecified, return code 500 or 503.

Now do the resource design procedure all over again for 'custom places'.

Figure Out the Data Set: custom places are created by clients. A client can 
create any number of places for which I have maps. Every custom place is 
associated with some user account. Custom places can be private or public. 
Private custom places can only be viewed and modified by someone who owns the 
place.

Split the Data Set into Resources: each custom place will be a resource. User 
account will be expanded to show the list of custom places for that account.

Name the Resources with URIs: custom place is a subordinate resource. Each 
custom place has a geographic point and a URI pattern 
/user/{username}/{planet}/{latitude},{longitude}/{place name}.

Expose a Subset of the Uniform Interface: GET and HEAD can be used to retrieve a
representation. Custom places can be DELETEed and their state change with PUT. 
Custom places are created by adding a comment to built in places or by creating 
a brand new custom place. Use POST when adding content to an existing place 
(create a subordinate resource) and use PUT to create a new custom place.   

Design the Representation(s) Accepted from the Client: when creating a new place,
the client sends key value pairs as form encoded strings. Variables are planet,
latitude, longitude and name. Information in the URI as scoping info doesn't 
have to be repeated in the representation. 

Design the Representation(s) Served to the Client: custom places look the same 
as built in places. A guide on how an authenticated client can edit a place will 
be tacked onto the representation. 

Link This Resource to Existing Resources: when an account is DELETEed, delete 
all the custom places as well. Custom place will have links to user who created 
it, instructions on how to create a custom place, ...

What’s Supposed to Happen?: as you would expect.

What Might Go Wrong?: as you would expect.

Chapter 7: A Service Implementation

Appendix A: a list of real RESTful services from which you could learn.

Django (Python), Restlet (Java) and Ruby on Rails are frameworks that help you 
expose resources.

The author will use Ruby on Rails to construct the application very similar to 
del.icio.us, a website where users can share bookmarks.
1) Create a Rails application:
$ rails bookmarks

2) Install two Rails plugins and a Ruby gem:
$ cd bookmarks
$ script/plugin install acts_as_taggable
$ script/plugin install http_authentication
$ gem install atom-tools

3) Installed a database "bookmarks_development" and configured the 
config/database.yaml so Rails can connect to it.

4) Figuring Out the Data Set:
Resources: user accounts, bookmarks, tags and bundles.
User accounts: have a password and username, full name and email address and a 
list of subordinate resources: bookmarks.
Bookmarks: belongs to a user, has a URI, short and long description, timestamp, 
collection of tags, flag that says if it is public.
URI's: have a notion of newness.
Tags: have a name.
Bundles: user's decision to group up bookmarks.

5) Create a database schema and put it into db/migrate/001_initial_schema.rb:
 
class InitialSchema < ActiveRecord::Migration
  # Create the database tables on a Rails migration.
  def self.up
    # The 'users' table, tracking four items of state
    # plus a unique ID.
    create_table :users, :force => true do |t|
      t.column :name, :string
      t.column :full_name, :string
      t.column :email, :string
      t.column :password, :string
    end
    # The 'bookmarks' table, tracking six items of state,
    # plus a derivative field and a unique ID.
    create_table :bookmarks, :force => true do |t|
      t.column :user_id, :string
      t.column :uri, :string
      t.column :uri_hash, :string # A hash of the URI.
      # See book text below.
      t.column :short_description, :string
      t.column :long_description, :text
      t.column :timestamp, :datetime
      t.column :public, :boolean
    end
    # This join table reflects the fact that bookmarks are subordinate
    # resources to users.
    create_table :user_bookmarks, :force => true do |t|
      t.column :user_id, :integer
      t.column :bookmark_id, :integer
    end
    # These two are standard tables defined by the acts_as_taggable
    # plugin, of which more later. This one defines tags.
    create_table :tags do |t|
      t.column :name, :string
    end
    # This one defines the relationship between tags and the things
    # tagged--in this case, bookmarks.
    create_table :taggings do |t|
      t.column :tag_id, :integer
      t.column :taggable_id, :integer
      t.column :taggable_type, :string
    end
    # Four indexes that capture the ways I plan to search the
    # database.
    add_index :users, :name
    add_index :bookmarks, :uri_hash
    add_index :tags, :name
    add_index :taggings, [:tag_id, :taggable_id, :taggable_type]
  end
  # Drop the database tables on a Rails reverse migration.
  def self.down
    [:users, :bookmarks, :tags, :user_bookmarks, :taggings].each do |t|
      drop_table t
    end
  end
end

6) Create the schema by running:
$ rake db:migrate

7) Resource Design:
Bookmarks API:
posts/get: Search your posts by tag or date, or search for a specific bookmarked 
URI.

posts/recent: Fetch the n most recent posts by the authenticated user. The 
client may apply a tag filter: “fetch the n most recent posts that the 
authenticated user tagged with tag t”.

posts/dates: Fetch the number of posts by the authenticated user for each day: 
perhaps five posts on the 12th, two on the 15th, and so on. The client may apply 
a tag filter here, too.

posts/all: Fetch all posts for the authenticated user, ever. The client may 
apply a tag filter.

posts/update: Check when the authenticated user last posted a bookmark. Clients 
are supposed to check this before deciding to call the expensive posts/all.

posts/add: Create a bookmark for a URI. The client must specify a short 
description. It may choose to specify a long description, a set of tags, and a 
timestamp. A bookmark may be public or private (the default is public). A client 
may not bookmark the same URI more than once: calling posts/add again overwrites 
the old post with new information.

posts/delete: Deletes a user’s post for a particular URI.
Tags API:
tags/get: Fetch a list of tags used by the authenticated user.

tags/rename: Rename one of the authenticated user’s tags. All posts tagged with 
the old name will now be tagged with the new name instead.
Bundles API:
tags/bundles/all: Fetch the user’s bundles. The resulting document lists the 
bundles, and each bundle lists the tags it contains.

tags/bundles/set: Group several tags together into a (possibly new) bundle.

tags/bundles/delete: Delete a bundle.
Interesting functions:
/{username}: Fetch any user’s bookmarks.

/{username}/{tag}: Fetch any user’s bookmarks, applying a tag filter.

/tag/{tag-name}: Fetch bookmarks tagged with a particular tag, from all users.

/url/{URI-MD5}: Fetch the list of users who have bookmarked a particular URI. 
The {URI-MD5} happens to be the MD5 hash of the URI, but from the average client’s
point of view that’s not important: it’s an opaque string of bytes that somehow 
identifies a URI within the del.icio.us system.

/recent: Fetch the most recently posted bookmarks, from all users. The 
del.icio.us home page also shows this information.

8) REST is Rails:
Rails doesn't let you define your resources directly, but instead divides up an 
application's functionalities into controllers.
Controllers expose the resources and have special methods that correspond to the 
methods of HTTP's uniform interface.
Lists and items are two resources that show up all the time. Every database 
table is a list that contains items. Rails assumes you can make every resource 
you expose into either a list or an item.
Root URI is http://localhost:3000/v1. When it says /users, the ful URI is 
http://localhost:3000/v1/users.

9) Users controller:
Class called UserController exposes a list of users at URI /users. It also 
exposes a resource for every user on the system at a URI that also incorporates 
the user ID in the database (example users/52). Resources expose a subset of the 
HTTP's uniform interface which is defined in the superclass of all controller 
classes.
To create new users, use UsersController#create. Don't want to let users get the 
list of all users. /users/52 is ugly, implement the full username. Implement 
POST, GET, PUT and DELETE.

10) Bookmarks controller:
Base URI is /users/{username}/bookmarks. Expose a bookmark as a MD5 hash 
(/v1/users/leonardr/bookmarks/55020a5384313579a5f11e75c1818b89).
Create bookmarks by sending POST to its own bookmark list resource.
BookmarksController implements: index, create, show, update and delete.

11) User tags controller:
Base URI is /users/{username}/tags. 

STOPPED AT PAGE 177
12) Calendar Controller:

13) URI Controller:

14) Bundles Controller:


On page 179 there is a large table detailing the operations and HTTP interface 
on the service.

15) Implementation: The routes.rb File:
Implement controllers as Ruby classes and map URI's to classes using routes.rb.
There are six controller classes: UsersController, BookmarksController, 
TagsController, CalendarController, RecentController, and UrisController.

# service/config/routes.rb
ActionController::Routing::Routes.draw do |map|
  base = '/v1'
  ## The first controller I define is the UsersController. The call to
  ## map.resources sets it up so that all HTTP requests to /v1/users
  ## or /v1/users/{username} are routed to the UsersController class.
  # /v1/users => UsersController
  map.resources :users, :path_prefix => base
  ## Now I'm going to define a number of controllers beneath the
  ## UsersController. They will respond to requests for URIs that start out
  ## with /v1/users/{username}, and then have some extra stuff.
  user_base = base + '/users/:username'
  # /v1/users/{username}/bookmarks => BookmarksController
  map.resources :bookmarks, :path_prefix => user_base
  # /v1/users/{username}/tags => TagsController
  map.resources :tags, :path_prefix => user_base
  # /v1/users/{username}/calendar => CalendarController
  map.resources :calendar, :path_prefix => user_base
  ## Finally, two more controllers that are rooted beneath /v1.
  # /v1/recent => RecentController
  map.resources :recent, :path_prefix => base
  # /v1/uris => UrisController
  map.resources :uris, :path_prefix => base
end

16) Design the Representation(s) Accepted from the Client:

17) Design the Representation(s) Served to the Client:

18) Connect Resources to Each Other:

19) What’s Supposed to Happen?:

20) What Might Go Wrong?:

21) Heart of the application:

A) Controller Code:
First, define a base class ApplicationController, then define the other six 
controllers.

STOPPED AT 188

