## [What is Gradle?](https://docs.gradle.org/current/userguide/what_is_gradle.html#what_is_gradle)

Gradle is a build automation tool.  
Features:
* high performance
* JVM foundation
* conventions
* extensibility
* IDE support
* insight

### Five things about Gradle

#### 1. Gradle is a general-purpose build tool

Gradle only supports Maven and Ivy repositories.  

Gradle allows you to build any software, because it makes few assumptions about what you’re trying to build or how it should be done. The most notable restriction is that dependency management currently only supports Maven- and Ivy-compatible repositories and the filesystem.

This doesn’t mean you have to do a lot of work to create a build. Gradle makes it easy to build common types of project — say Java libraries — by adding a layer of conventions and prebuilt functionality through plugins. You can even create and publish custom plugins to encapsulate your own conventions and build functionality.
2. The core model is based on tasks

Gradle models its builds as Directed Acyclic Graphs (DAGs) of tasks (units of work). What this means is that a build essentially configures a set of tasks and wires them together — based on their dependencies — to create that DAG. Once the task graph has been created, Gradle determines which tasks need to be run in which order and then proceeds to execute them.

This diagram shows two example task graphs, one abstract and the other concrete, with the dependencies between the tasks represented as arrows:
Example task graphs
Figure 1. Two examples of Gradle task graphs

Almost any build process can be modeled as a graph of tasks in this way, which is one of the reasons why Gradle is so flexible. And that task graph can be defined by both plugins and your own build scripts, with tasks linked together via the task dependency mechanism.

Tasks themselves consist of:

    Actions — pieces of work that do something, like copy files or compile source

    Inputs — values, files and directories that the actions use or operate on

    Outputs — files and directories that the actions modify or generate

In fact, all of the above are optional depending on what the task needs to do. Some tasks — such as the standard lifecycle tasks — don’t even have any actions. They simply aggregate multiple tasks together as a convenience.
✨
	You choose which task to run. Save time by specifying the task that does what you need, but no more than that. If you just want to run the unit tests, choose the task that does that — typically test. If you want to package an application, most builds have an assemble task for that.

One last thing: Gradle’s incremental build support is robust and reliable, so keep your builds running fast by avoiding the clean task unless you actually do want to perform a clean.
3. Gradle has several fixed build phases

It’s important to understand that Gradle evaluates and executes build scripts in three phases:

    Initialization

    Sets up the environment for the build and determine which projects will take part in it.

    Configuration

    Constructs and configures the task graph for the build and then determines which tasks need to run and in which order, based on the task the user wants to run.

    Execution

    Runs the tasks selected at the end of the configuration phase.

These phases form Gradle’s Build Lifecycle.
✨

Comparison to Apache Maven terminology

Gradle’s build phases are not like Maven’s phases. Maven uses its phases to divide the build execution into multiple stages. They serve a similar role to Gradle’s task graph, although less flexibly.

Maven’s concept of a build lifecycle is loosely similar to Gradle’s lifecycle tasks.

Well-designed build scripts consist mostly of declarative configuration rather than imperative logic. That configuration is understandably evaluated during the configuration phase. Even so, many such builds also have task actions — for example via doLast {} and doFirst {} blocks — which are evaluated during the execution phase. This is important because code evaluated during the configuration phase won’t see changes that happen during the execution phase.

Another important aspect of the configuration phase is that everything involved in it is evaluated every time the build runs. That is why it’s best practice to avoid expensive work during the configuration phase. Build scans can help you identify such hotspots, among other things.
4. Gradle is extensible in more ways than one

It would be great if you could build your project using only the build logic bundled with Gradle, but that’s rarely possible. Most builds have some special requirements that mean you need to add custom build logic.

Gradle provides several mechanisms that allow you to extend it, such as:

    Custom task types.

    When you want the build to do some work that an existing task can’t do, you can simply write your own task type. It’s typically best to put the source file for a custom task type in the buildSrc directory or in a packaged plugin. Then you can use the custom task type just like any of the Gradle-provided ones.

    Custom task actions.

    You can attach custom build logic that executes before or after a task via the Task.doFirst() and Task.doLast() methods.

    Extra properties on projects and tasks.

    These allows you to add your own properties to a project or task that you can then use from your own custom actions or any other build logic. Extra properties can even be applied to tasks that aren’t explicitly created by you, such as those created by Gradle’s core plugins.

    Custom conventions.

    Conventions are a powerful way to simplify builds so that users can understand and use them more easily. This can be seen with builds that use standard project structures and naming conventions, such as Java builds. You can write your own plugins that provide conventions — they just need to configure default values for the relevant aspects of a build.

    A custom model.

    Gradle allows you to introduce new concepts into a build beyond tasks, files and dependency configurations. You can see this with most language plugins, which add the concept of source sets to a build. Appropriate modeling of a build process can greatly improve a build’s ease of use and its efficiency.

5. Build scripts operate against an API

It’s easy to view Gradle’s build scripts as executable code, because that’s what they are. But that’s an implementation detail: well-designed build scripts describe what steps are needed to build the software, not how those steps should do the work. That’s a job for custom task types and plugins.
✨


There is a common misconception that Gradle’s power and flexibility come from the fact that its build scripts are code. This couldn’t be further from the truth. It’s the underlying model and API that provide the power. As we recommend in our best practices, you should avoid putting much, if any, imperative logic in your build scripts.

Yet there is one area in which it is useful to view a build script as executable code: in understanding how the syntax of the build script maps to Gradle’s API. The API documentation — formed of the Groovy DSL Reference and the Javadocs — lists methods and properties, and refers to closures and actions. What do these mean within the context of a build script? Check out the Groovy Build Script Primer to learn the answer to that question so that you can make effective use of the API documentation.
✨
	As Gradle runs on the JVM, build scripts can also use the standard Java API. Groovy build scripts can additionally use the Groovy APIs, while Kotlin build scripts can use the Kotlin ones.
