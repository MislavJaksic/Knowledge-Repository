## [Ambari](https://ambari.apache.org/)

Aapche Ambari is a administration software for managing Hadoop clusters. Apache Hadoop is a software for distributed parallel
problem solving.

### [Documentation](https://cwiki.apache.org/confluence/collector/pages.action?key=AMBARI)

Warning: some pages are duplicates of other pages. 2.4.0 documentation seems to be the most up to date.

### Installation

See [Ambari, VirtualBox, Vagrant and Hadoop Stack Installation](https://cwiki.apache.org/confluence/display/AMBARI/Quick+Start+for+New+VM+Users).  
See [Quick Start Guide](https://cwiki.apache.org/confluence/display/AMBARI/Quick+Start+Guide).  

See [Tools for building Ambari](https://cwiki.apache.org/confluence/display/AMBARI/Ambari+Development).  
See [Build and install without VM](https://ambari.apache.org/).  

### [Dashboard](https://cwiki.apache.org/confluence/display/AMBARI/Enhanced+Service+Dashboard+-+2.4.0)

Dashboard has a lot of colourful widgets.

#### [Metrics](https://cwiki.apache.org/confluence/display/AMBARI/Ambari+Server+Metrics)

Can add new widgets, constructs that display data.
Widget types: Graph, Gauge, Number, Template
Widgets are specified in JSON.

[Ambari Metrics System](https://cwiki.apache.org/confluence/display/AMBARI/Metrics+-+2.4.0)

#### Heatmaps

The "Heatmaps" show all kinds of useful metrics, such as memory allocation, processor speed and similar physical
characteristics.

#### Config History

The "Config History" tab shows all the current and previous "Config Groups" changed. See the Configs section under Services.

### Services

The "Services" tab shows all the installed services.
| Service symbol | Meaning |
| :--- | :---: |
| Green check mark | "Active" |
| Black doctor's bag | "in Maintenance mode" |
| Computer icon | "Inactive" |

#### [Config](https://cwiki.apache.org/confluence/display/AMBARI/Enhanced+Configs+-+2.4.0)

Configs set in Ambari override all manual configurations.

On the "Services" tab a number of services can be selected.  
* Each service has a "Summary" and "Configs" tab. (Note: some also have "Heatmaps")  
    * The "Configs" tab has "Settings" and "Advanced" tabs.  
        * In the "Advanced" tab a number of properties can be changed. (Note: not all properties are displayed)  
            * If some properties are missing you can attempt to add them by opening one of the "Custom _conf_file" dropdowns
and clicking "Add Property ...".  

Config group can be changed by clicking on the "Manage Config Groups". There, you can duplicate the current
settings and then change them. When done, you can assign a host to the appropriate settings group.  

### [Alerts](https://cwiki.apache.org/confluence/display/AMBARI/Alerts+-+2.4.0)

TODO
