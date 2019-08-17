## [IntelliJ IDEA](https://www.jetbrains.com/idea/)

There is a student licence, a professional licence, but also a free licence (Community Edition).  
Community Edition has quite a few restrictions (for example neither Node.js nor Django can be integrated).  

### [Installation](https://www.jetbrains.com/help/idea/install-and-set-up-product.html)

Quite simple. Nothing out of the ordinary. Follow the online instructions.  

### [Discover IntelliJ](https://www.jetbrains.com/help/idea/discover-intellij-idea.html)

Create code/insert template: ALT+INSERT  

Code Completion: CTRL+SPACE  

Show usages: CTRL+ALT+F7  
Show implementations: CTRL+ALT+B  

IntelliJ supports all kinds of refactoring.  

Inspections and fixes: ALT+ENTER  

Reformat code: CTRL+ALT+L  

Version Control: ALT+9  

Compile/make: CTRL+F9  
Run: SHIFT+F10  
Debug: SHIFT+F9  

[Working with App Servers](https://www.jetbrains.com/help/idea/application-servers-support.html)  
Examples of App Servers: Geronimo, Google App Engine, Tomcat, TomEE, WebLogic...  

Supports working with Maven and Gradle.  
Supports migrating from NetBeans and Eclipse.  

### [Configuring IntelliJ](https://www.jetbrains.com/help/idea/configuring-project-and-ide-settings.html)

TODO

### [Configuring projects](https://www.jetbrains.com/help/idea/working-with-projects.html)

TODO  
and many more subjects...  

### Learning how to use IntelliJ IDEA

Help -> Tip of the Day: for quick tips.

CTRL+N: open class.  
CTRL+SHIFT+N: open file.  
CTRL+Space: code completion.  
ALT+SHIFT+7: find all places where a name is used.  
CTRL+Q: view documentation.  
CTRL+B: jump to declaration.  
SHIFT+F6: rename.  
CTRL+O: override methods.  
CTRL+I: implement interface.  
CTRL+SHIFT+Space: code complete with suitable variables.  
ALT+Insert: generate getters and setters.  
CTRL+ALT+T: surround selected with code (try/catch).  
CTRL+ALT+B: jump to the implementation an abstract method.  
SHIFT+F1: view external documentation.  
... and there are even more tips.  

CTRL+SHIFT+NumPad-/+: collapse/uncollapse all.

### Generate JavaDocs

Before you generate JavaDoc make sure your project structure is sound and that you have documented everything according to the [rules](https://github.com/MislavJaksic/KnowledgeRepository/tree/master/ProgrammingLanguages/Java/Documenting).

Under "Tools" -> "Generate JavaDoc...".

### IntelliJ plugins

If you want to install a plugin, download it from [JetBrains](https://plugins.jetbrains.com/).

Go to "Settings" (CTRL + ALT + S) and got to the "Plugins" tab.  
Click on "Install plugin from disk..." and choose a plugin you want to install.  

### Maven project

##### Create a project

Create from File -> New... -> Maven -> ...  
If you want, you can create an Archtype, a template project or you can just click Next.  
Fill in both of these:  
* groupId - creator's ID  
* artifactId - JAR or project name  

### Adding dependencies

You can add dependencies by simply copying the XML from the Maven Central Repository into the "pom.xml".
Sometimes it can be hard to find the right JAR in all of the many subfolders of an external project. You can download the [JARExplorer](https://github.com/javalite/jar-explorer) to aid you in your search.  

#### Build, plugins and packaging

You can package the project into a .jar by adding <packaging>jar</packaging> into "pom.xml".  
To package the project, that is, execute the Maven goal "mvn package" you can open the Maven project view. Click on the icon in the bottom left corner of the window.  
Plugins can range from utilities, to those that allow you to execute the project from the command line like "exec-maven-plugin".  

#### Deployment

If you want to transfer the project, package the whole project into a .zip or something similar and install it with "mvn install".  
If you have the "exec-maven-plugin", you can execute the project from the command line with "mvn exec:java".  
