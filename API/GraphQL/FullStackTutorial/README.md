## [Fullstack Tutorial for GraphQL](https://www.howtographql.com/)

### Introduction

API defines how a client can load data from a server.  
GraphQL is a query language for APIs.  

### GraphQL is better then REST

GraphQL is better then REST:
* get data with a single request
* has a precise schema and type system
* quick to develop

REST is server efficient while GraphQL is client friendly.  

### Core Concepts

```
Schema: defines the API
Type: GraphQL is strongly typed
Field: has a name and data

Root field (of the query): top-level "fields"
Payload (of the query): says what you're asking the client

Mutations: create, update, delete and other functions which change data

Subscription: be alerted when a change happens
```

#### Schema Definition Language (SDL)
```
type Type-Name0 {
  Field-Name1: Type-Name1!  # "!" field is non-null
  Field-Name2: [Type-Name2]  # [] is an array field
}
```

Define a 1-N relationship:
```
type Person {                        type Post {
  name: String!          1-N             title: String!
  age: Int!          relationship        author: Person!
  posts: [Post!]!                    }
}                                    
```

#### Query

```
{                                            {
  Root-Field (_argument: _value) {             allPersons (last: 2) {
    _payload                                     name
  }                                   ->         age
}                                                posts {
                                                   title
                                                 }
                                              }
                                            }
```

#### Mutations

```
mutation {
  createPerson(name: "Bob", age: 36) {
    name
    age
  }
}
```

#### Subscription

```
subscription {
  newPerson {
    name
    age
  }
}
```

#### Schema

```
type Query {
  allPersons(last: Int): [Person!]!
}

type Mutation {
  createPerson(name: String!, age: Int!): Person!
}

type Subscription {
  newPerson: Person!
}

type Person {
  name: String!
  age: Int!
  posts: [Post!]!
}

type Post {
  title: String!
  author: Person!
}

# Note: Query, Mutation, and Subscription types are entry points
# Note: allPersons, createPerson and newPerson are root fields
```

### Big Picture (Architecture)

GraphQL is a specification.  

Use cases:  
1) expose data in a database (AWS Aurora/MongoDB/...)
2) integrates existing systems (legacy/microservice/third-party/...)
3) mix of 1) and 2)

Resolver function is responsible for fetching the data for a field.  
The server will package all the data and send it as a response.  

#### Query resolver functions

```
query {                            
  User(id: _value) {               
    name                         User(id: String!): User
    friends(first: 5) {    ->    name(user: User!): String!
      name                       age(user: User!): Int!
      age                        friends(first: Int, user: User!): [User!]!
    }                              
  }                                
}                                  

```

### Clients

Advantages of GraphQL:
* query and mutatate directly
* view layer integration
* normalized, flat cache
* validation and documentation
* collocate views and data

### Server

Describe data instead of optimizing endpoints.  
GraphQL resolves queries using resolver functions which fill in every field.  
Possible to batch resolve a query (DataLoader).  


### More GraphQL Concepts

#### Fragments

Inheritance for queries.

```
type User {               fragment addressDetails on User {
  name: String!             name
  age: Int!                 street
  email: String!            zipcode
  street: String!           city
  zipcode: String!        }
  city: String!           
}                         
```

```
{                               {
  allUsers {                      allUsers {
    ... addressDetails    ==        name
  }                                 street
}                                   zipcode
                                    city
                                  }
                                }
```

#### Aliases

```
# Without alias
{
  User(id: "1") {
    name
  }
  User(id: "2") { # Won't work!
    name
  }
}
```

```
# With alias                     
{                                {
  first: User(id: "1") {           "first": {
    name                             "name": "Alice"
  }                          ->    },
  second: User(id: "2") {          "second": {
    name                             "name": "Sarah"
  }                                }
}                                }
```

### SDL types

```
Scalar: String, Int, Float, Boolean, and ID
Object: have fields which are either scalar or other objects.
```
#### Enums

```
enum Weekday {
  MONDAY
  TUESDAY
  WEDNESDAY
  THURSDAY
  FRIDAY
  SATURDAY
  SUNDAY
}
```

#### Interface

```
interface Node {        type User implements Node {
  id: ID!                 id: ID!
}                         name: String!
                          age: Int!
                        }
```

#### Union

```
type Adult {           type Child {
  name: String!          name: String!
  work: String!          school: String!
}                      }

union Person = Adult | Child

# Note: Person is either an Adult or a Child
# Note: Adult and Child are a Person
```

Solve aliasing problem with conditional fragments:
```
{
  allPersons {
    name # works for Adult and Child
    ... on Child {
      school
    }
    ... on Adult {
       work
    }
  }
}
```

### Tooling and Ecosystem

GraphQL has introspection. It allows clients to find what they can access thought the API.

Consider using [GraphQL Playground](https://github.com/prisma/graphql-playground) or [GraphiQL.](https://github.com/graphql/graphiql).

### Security

Prevent your GraphQL server from crashing.  

Timeout: stop execution after X seconds; unreliable
Maximum Query Depth: reject queries deeper then X
Query Complexity: set complexity for every field; unreliable
Throttling Based on Server Time: [leaky bucket algorithm](https://en.wikipedia.org/wiki/Leaky_bucket)
Throttling Based on Query Complexity: what GitHub public API uses

### Common Questions

Q: REST always returns the same data structure and can therefore cache queries. How do you cache server-side in GraphQL when you don't know what the client will request next?  
A: It cannot. The best it can do is hope the client will do it.  

Q: How do you implement Authentication and Authorization?  
A: Using [OAuth](https://oauth.net/) and permission rules such as [Graphcool](https://www.graph.cool/docs/reference/auth/overview-ohs4aek0pe).

Q: How do you Handle Errors?  
A: By returning an "error" field.

Q: How do you support offline usage?  
A: See [Relay issue](https://github.com/facebook/relay/issues/676), [Apollo](https://github.com/apollographql/apollo-client/issues/424) and [Redux Offline blogpost](http://www.petecorey.com/blog/2017/07/24/offline-graphql-queries-with-redux-offline-and-apollo/?from=east5th.co).  
