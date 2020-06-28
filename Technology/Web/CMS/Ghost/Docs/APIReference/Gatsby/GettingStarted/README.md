## [GraphQL, Gatsby & the Ghost API](https://ghost.org/docs/api/v3/gatsby/graphql-gatsby-ghost-api/)

### Getting Started

```
$: npm install --save gatsby-source-ghost
```

You will need:
* API URL
* `Content API` key found under Ghost `Integration`s

Create `gatsby-config.js`.  

### Querying Graph with GraphQL

The Ghost API provides 5 types of nodes:
* `Post`
* `Page`
* `Author`
* `Tag`
* `Settings`

```
{
  allGhostPost(sort: { order: DESC, fields: [published_at] }) {
    edges {
      node {
        id
        slug
        title
        html
        published_at
      }
    }
  }
}
```
