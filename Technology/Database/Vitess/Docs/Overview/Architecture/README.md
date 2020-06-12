## [Architecture](https://vitess.io/docs/overview/architecture/)

To arrive at a full Vitess implementation either:
* define the database topology
* scale existing databases

Vitess’ components:
* Vitess Runtime:
    * Application
    * VTGate
    * Topology (metadata store)
    * VTTablet
    * MySQL/MariaDB
* Admin:
    * vtctl: Command line
    * vtctl: GUI
