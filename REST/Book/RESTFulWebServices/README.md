# RESTful Web Services

Written by Leonard Richardson and Sam Ruby it talks about RESTful, Resource-Oriented web services.  

What follows is a brief summary of their book.  

## Chapter 1: Programmable Web

URI is also a URL. Almost identical.  
Type a URI into a browser and you get a HTML page.  
Web browser: a gateway to many services and data. No need to install them.  

The programmable web is just like the human web, but it serves XML instead of HTML documents.

A browser just shows the human the document.  
A service has to determine the meaning of the dcoument has well.  

The web connects programs just like it does with humans.

### Kinds of Things on the Programmable Web

The programmable web is based on HTTP and XML.  
Classify services not by technology (URI, SOAP, XML_RRPS, ...) but by architecture.  

### HTTP: Documents in Envelopes

HTTP, a document protocol, it puts a document into an envelope to be sent.  
HTTP is only strict about how the envelope, not what goes into it.  

HTTP GET request for "http://www.oreilly.com/index.html":
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
[Request Header]
...
[Request Header]
[Entity-Body]
```

HTTP GET response from http://www.oreilly.com/index.html:  
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
[Request Header]
...
[Request Header]
[Entity-Body]
```

```
HTTP Method      -> how the server should process the envelope
Response Code    -> consequences of the request
Path             -> address; portion of the URI after the hostname
Request Headers  -> metadata
Response Headers -> metadata
Entity-Body      -> document
```

Response header "Content-Type" determines the media type in "Entity-Body".  
For text documents its "text/html", for structured text "application/xml" and for images "image/jpeg".  

### Method Information

TODO

- Method information: how the client can convey its intentions to the server. Most common HTTP methods are GET, HEAD,
PUT, DELETE and POST. Some services define their own method information.
- Scoping information: how the client tells the server which part of the data set to operate on. Many web services
put scoping information in the path. In http://www.google.com/search?q=REST that would be /search?q=REST.

Example of identical HTTP GET requests (difference is at the architecture level):
| HTTP GET request | Method information | Scoping information |
| -- | -- | -- |
| http://flickr.com/photos/tags/penguin | GET | "Photos tagged 'penguin'" |
| http://api.flickr.com/services/rest/?method=flickr.photos.search&tags=penguin | "Do a photo search" | 'Penguin' |

XPath primer: XPath is read from right to left. "//photo" means: find every photo tag (photo), no matter where it is in the
document (//).

Architectures:
- RESTful, Resource-Oriented Architectures
  - Services should look like the rest of the web.
  - In RESTful architectures, the method information goes into the HTTP method. In Resource-Oriented Architectures,
the scoping information goes into the URI.
  - RESTful web services share a standard vocabulary.

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

## Chapter 2: Writing Web Service Clients

In this chapter, a client will be shown that handles RESTful and hybrid services.

Every web service request involves the same three steps:
- Input data into the HTTP request: the HTTP method, the URI, any HTTP header and any document that needs to go into
the entity body.
- Format the data as an HTTP request, and send it to the appropriate HTTP server.
- Rarse the response data.

Instead of following this process every time you want to make a web service request, you can write a wrapper method
to abstract the process. Some APIs have an official wrappers, but you can always make your own.

Sample client: open a TCP socket connection, send a HTTP request, get the response, close the connection.
HTTP libraries: almost every language has one, they make an HTTP request. They need quite a few methods to be
considered actual usable libraries.

>Good HTTP libraries:
>  Ruby: rest-open-uri and net/http
>  Python: httplib2
>  Java: HttpClient
>  C#: System.Web.HTTPWebRequest
>  PHP: libcurl
>  JavaScript: XMLHttpRequest
>  From command line: program curl
>  Lisp: simple-http

There are three kinds of XML parsers:
- the document-based strategy of DOM and other treestyle parsers (simplest)
  - XML document as nested data structure
  - process XML with XPath, CSS selectors
  - have to load the whole document into memory
  - can use random access to grab data
- event-based strategy of SAX and “pull” parsers
  - turns XML into a stream of events, starting and closing tags, XML comments, and entity declarations
  - pull parser is useful when you need to handle almost every event
  - SAX parser is useful when you need to handle a few events as you have to register callback functions
  - cannot randomly access data
  - need to check XML is well formed of the parser may crash

>Good XML parsers:
>  Ruby: REXML
>  Python: ElementTree
>  Java: javax.xml, Xerces, or XMLPull
>  C#: System.Xml.XmlReader
>  JavaScript: responseXML

More and more web services return JSON documents instead of XML.

>Good JSON parser: visit the JSON website and look for them.

WADL file describes HTTP requests: which URIs you can visit, what data those URIs expect you to send, and what data
they serve in return.
WADL library can parse this file and model the space of possible service requests.
WADL adoptions is extremely poor, but you can write WADL files for someone else's services.

## Chapter 3: What makes RESTful services different?

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

## Chapter 4: Resource Oriented Architecture (ROA)

ROA is a way of turning a problem into a problem into a RESTful service: URIs, HTTP and XML that work like the rest
of the web.

Keep the following in mind: RESTful strives keep the scoping info in the URI (principle of addressability) and the
method info in the HTTP method (principle of the uniform interface).

A resource is anything that is important enough to be referenced. That is too vague, here are a few examples: latest
version of the software, first blog entry for October 24, 2006, info about jellyfish, next five prime number after
1024, ...
A resource has to have at least one URI. URI is the name and the address of the resource.

URIs should be descriptive, have a structure and be predictable. 
Multiple URIs can point to the same resource, but there should be a reason why.

1) Addressability is a property of an application to logically and understandably expose resources through convenient
URIs. 
Example of addressability: http://www.google.com/search?q=jellyfish can be inferred from the base URI
http://www.google.com.

2) Statelessness means that every HTTP request happens in complete isolation, the client should include all the info
in the HTTP request and the server should never relies on info provided by some other request.
Practically, that means every state of the server should have its own URI. There should be no sequencing of requests,
they should be invoked in any order.
Statelessness should be a property of the server, but it doesn't have to be a property of the client.
  Application state lives on the client. Example: current query and current page are examples of the state living on
the client. It is different for each client. Web service only cares about the client state when it makes a request.
  Resource state lives on the server. It is the same for every client.
Cookies and API keys that limit you to x number of request per day violate statelessness. API key is stored on the
client, but the request counter is stored on the server to keep users from cheating.

Representation is data about the current state of a resource. The resource can be represented in multiple ways.
It is possible for a representation to create a new resource as well as a resource being a source of representations.
Each resource representation should be given its own URI. Another way is to only expose a Platonic form URi and to
then ask the client which representation it would prefer.

3) Connectedness (links) is a property of a server to guide the path of the client by serving hypermedia links,
forms. A web service is connected to the extent that you can put the service in different states by following links.

4) Uniform Interface means using the basic methods HTTP provides to perform common operations.
HTTP GET, PUT, DELETE: GET gets a representation of a resource, PUT creates a new or overwrites an existing
resource, DELETE removes the existing resource.
HTTP HEAD, OPTIONS: HEAD gets a metadata only representation, OPTIONS checks which HTTP methods the resource
supports.
HTTP POST: used to create subordinate resources, a way of creating a new resource without having to know its exact
URI, used for appending information to an existing resource (unlike PUT which overrides it).
Difference between POST and PUT: use PUT when the client decides which URI it will give the resource and use POST
when the server decides which URI it will give the resource. POST is also for appending data while PUT for
overriding data.

POST overloading is when POST is used for providing a data handling process with a block of data. This is bad as it
is mimicking many different non-HTTP methods as one single HTTP method. However, sometimes it is unavoidable.

Safe HTTP methods are GET and HEAD because they never change the server state. You can make such requests once, ten
times or never at all and their result will always be the same. They will cause side effects, but those are not the
clients problem because it didn't ask for them.
Idempotency is the property of an operation to have the same effect no matter if you apply it once or multiple times.
Example: multiply with zero, 4*0 == 4*0*0*0*0
Idempotent HTTP methods are PUT and DELETE.

Safety and idempotency are important as they make HTTP request reliable even over an unreliable network.
POST is not idempotent nor safe.

The uniform interface is important because having one enables clients to use them more easily, like they use other
services on the web.

## Chapter 5: Designing Read Only ROA

Author will design a service that serves info about maps.

In object oriented design, you break down a system into nouns. Each noun is a class. ROA is similar.
A "class" as a HTTP resource exposes only six HTTP methods.
When tempted to create a new method, create a new resource instead.

The following process will produce a set of resources that will respond to HTTP methods:
- Figure out the data set
- Split the data set into resources
- For each kind of resource:
  - Name the resources with URIs
  - Expose a subset of the uniform interface
  - Design the representation(s) accepted from the client
  - Design the representation(s) served to the client
  - Integrate this resource into existing resources, using hypermedia links and
forms
  - Consider the typical course of events: what’s supposed to happen?
  - Consider error conditions: what might go wrong?

Example: create a web service that will serve maps

Figure out the data set: which maps? Those maps that use 2-D coordinates to
identify any given point on the map. Maps need to be addressable using latitude
and longitude. Those can be maps of cities, political maps, maps of celestial
bodies. Some points on the map are more interesting then others, there points
are called places. Users will want to return a place name in a point on the map.
Data set will include mappings of places to points. Places have a certain type:
cities, hot springs, crater. Service can find a place given its name, type or
description.

Split the data set into resources: expose the data set as HTTP resources.
Three commonly exposed kinds of resources:
- Predefined one off resources for important aspects of the application: top
level directory, for example a home page. Unique.
- Resource for every object exposed through the service: each object exposed by
the service has its own resource set.
- Resources representing the result of algorithms applied to the data set:
collection resources, the result of queries. A service either exposes none or an
infinite number of them. Called algorithmic resources.

Map service needs one special resource that will list all the planets. Every map
of the planet is also a resource. Those are one off resources.

Every point on the map is a resource. A point might represent a house, a
mountain or something else. Places are points which are identified by a name
rather then the coordinates, they too are resources. Those are object resources.

Sample algorithmic resources are: places on Earth called Springfield, towns in
France with pop less then 1000 and others.

Master list of resources are:
- list of planets
- place on a planet, identified by a name
- geographic points on the planet
- list of places that match a criteria
- map of a planet, centered around a point

RESTful services expose both ata and algorithms through resources. Think about
results of actions instead of actions (methods) themselves.

Name the resources: named after URIs. URIs contain all the scoping info. The
list of planets is the root URI, http://maps.example.com/.
Three basic rules for URI design:
- use path variables to encode hierarchy, /parent/child
- use punctuation characters in path variables to avoid implying hierarchy where
none exist, /parent/childOne;ChildTwo
- use query variables to imply inputs into an algorithm,
/search?q=jellyfish&start=20

Percent encoding primer: %20 in URI stands for a character that would otherwise
be considered special.

Sample hierarchy URIs: http://maps.example.com/Mars, http://maps.example.com/Earth
to identify planets. If you can extend the URI with something like
/Earth/France/Paris, then you know you have designed a good URI.

No hierarchy URIs: use comma when the order matters (,) and semicolon (;) when
it doesn't. /Earth/24.9195,17.821 and /Venus/3,-80 .

Different map type URIs: radar/Venus/65.9,7.00 and /geologic/Earth/43.9,-103.46 .

Different map scale URIs: /satellite.10/Earth/41,-112: 1:24,000 and /satellite.1/Earth/41,-112: 1:51,969,000 .

Algorithmic resource URIs: /Mars?show=craters+bigger+than+1km and /Earth/USA/Mount%20Rushmore?show=diners .
Sometimes, they are not necessary.

Master list of URIs:
- list of planets: /
- planet or a place on a planet: /{planet}/[{scoping-information}/][{place-name}],
the optional variable {scoping-information} will be a hierarchy of places, {place-name}
will be the name of the place and *show* can be tacked on at the end to access
algorithmic resources. 
- map of a planet, or a point on a map: /{map-type}{scale}/{planet}/[{scoping-information}],
{scoping-information} will be a pair of longitude and latitude values, {scale}
will be a dot and a number.

Design your representations: decide on the data format that will be send to the
client. Representation's job is to convey the state of the resource. Representation
should provide the levers of state, links to nearby resources (new application states).
The goal is connectedness, the ability to follow one resource to another by
following links. 
Representing:
- the list of planets: between plain text, JSON, XML and XHTML format, use XHTML
a good XML language for displaying lists of links.

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

- maps and points on maps: maps will be split into 256x256 tiles. When a client
requests a point, serve a hypermedia file that includes a link to a tiny map
image. Hypermedia files will also include links to adjacent points.

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

- map tiles: 

- planets and other places: follow a link from list of planets to a specific
planet, then follow more links from there. Places are represented by key-value
pairs.

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

Quick reminder: web services are just web sites for robots. RESTful services look
like web sites to humans.

- lists of search results: list of links to resources that are already defined.

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

Link resources to each other: that is by design, a lot of resources contain
links to other resources. However, there is no way for a client to generate a
search URI. Because there are infinitely many things for which a client can do a
search, you cannot just link to for example "diners". Solve it with HTML forms.
Send an appropriate HTML form in a representation to tell a client how to plug
in variables into the query string.

```xhtml
<form id="searchPlace" method="get" action="">
  <p>
    Show places, features, or businesses:
  <input id="term" repeat="template" name="show" />
  <input class="submit" />
  </p>
</form></screen>
```

HTTP response: consider possible response codes or HTTP headers that you will
send out. Read only services have a simple course of events: clients sends a GET
request to a URI, server sends a response code 200 (OK), HTTP  headers and a
representation. HEAD is the same, but it omits the representation.

HTTP headers are a large toolkit, but every web service should be built to
support the conditional HTTP GET.
Conditional HTTP  GET: implemented in two request headers (If- Modified-Since
and If-None-Match) and two response headers (Last-Modified and ETag). Because
most resources seldom change the server should signal the client that it can
use the cached version of the resource if it hasn't changed.

What might go wrong: accessing a map that doesn't exist (404), place is not in
the database (303 and send a HTTP response header Location which will contain
the URI of an alternative resource), impossible latitude or longitude (400),
a search yields no results (200), the server is overloaded (503) and the server
is not functioning correctly (500).

Chapter 6: Designing Read/Write Resource-Oriented Services

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

