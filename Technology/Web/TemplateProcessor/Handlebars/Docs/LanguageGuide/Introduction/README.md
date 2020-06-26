## [Introduction](https://handlebarsjs.com/guide/)

### What is Handlebars?

A templating language.  
Input: template and an input object.  
Output: HTML or other document format.  

```
<p>{{firstname}} {{person.lastname}}</p>    
               +++                        -->  <p>Yehuda Katz</p>
{
  firstname: "Yehuda",
  person: {
    lastname: "Katz",
  },
}
```

### Installation

Paste some code into an `HTML` document.  
Open the `Developer Console` to see the result.  

```
<script src="https://cdn.jsdelivr.net/npm/handlebars@latest/dist/handlebars.js"></script>
<script>
  var template = Handlebars.compile("Handlebars <b>{{doesWhat}}</b>");
  console.log(template({ doesWhat: "rocks!" }));
</script>
```

### Evaluation context

`with`: descend into object-property  
`each`: iterate an array

```
{{#with person}}              {
{{firstname}} {{lastname}}      person: {
{{/with}}                  ++     firstname: "Yehuda",
                                  lastname: "Katz",
                                },
                              }
<ul class="people_list">      {
  {{#each people}}              people: [
    <li>{{this}}</li>     ++      "Yehuda Katz",
  {{/each}}                       "Alan Johnson",
</ul>                             "Charles Jolley",
                                ],
                              }
```

### Template comments

```
{{! Doesn't show up in the output}}
<!-- Shows up as HTML-comment -->
{{!-- May contain mustaches like }} --}}
```

### Custom Helpers

```
{{#each people}}                                           
   {{print_person}}                                        
{{/each}}                                                  
               +++                                         
Handlebars.registerHelper('print_person', function () {    
    return this.firstname + ' ' + this.lastname;          -->  Nils Knappmeier
});                                                            Yehuda Katz
               +++                                         
{                                                          
  people: [                                                
    {                                                      
      firstname: "Nils",                                   
      lastname: "Knappmeier",                              
    },                                                     
    {                                                      
      firstname: "Yehuda",                                 
      lastname: "Katz",                                    
    },                                                     
  ],                                                       
}                                                          
```

### Block Helpers

You can pass a context to a helper.  

```
# Note: persons is passed to items
# Note: fn property is passed to options
{{#list people}}{{firstname}} {{lastname}}{{/list}}                              
               +++
Handlebars.registerHelper("list", function(items, options) {                     
  const itemsAsHtml = items.map(item => "<li>" + options.fn(item) + "</li>");    
  return "<ul>\n" + itemsAsHtml.join("\n") + "\n</ul>";                            <ul>
});                                                                           -->    <li>Yehuda Katz</li>
               +++                                                                   <li>Carl Lerche</li>
{                                                                                  </ul>
  people: [
    {                                                                            
      firstname: "Yehuda",                                                       
      lastname: "Katz",                                                          
    },                                                                           
    {                                                                            
      firstname: "Carl",                                                         
      lastname: "Lerche",                                                        
    },                                                                           
  ],                                                                             
}                                                                  
```

### HTML Escaping

```
raw: {{{specialChars}}}
               +++
{ specialChars: "& < > \" ' ` =" }
```

### Partials

Partials are templates called by other templates.  

```
{{#each persons}}                                       
  {{>person person=.}}                                  
{{/each}}                                               
               +++                                      
Handlebars.registerPartial(                             
    "person",                                              Nils is 20 years old.
    "{{person.name}} is {{person.age}} years old.\n"  -->  Teddy is 10 years old.
)                                                          Nelson is 40 years old.
               +++                                      
{                                                       
  persons: [                                            
    { name: "Nils", age: 20 },                          
    { name: "Teddy", age: 10 },                         
    { name: "Nelson", age: 40 },                        
  ],                                                    
}                                                       
```
