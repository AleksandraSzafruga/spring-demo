### MVC pattern
    * M - model
    * V - view
    * C - controller

V - widoki są serwowane przez kontroler
C - serwuje widoki/odbiera request'y
M - dane i operacje na nich

Model = Service + Repository

### Aplikacja webowa
View
Controller
Service
Repository

### Aplikacja standalone
Service
Repository


REST
* HTTP
* JSON
* CRUD na HTTP
    * hierarchiczne adresy
    * Read - GET --> \books
    * Read on - GET -->\books\{id}
    * Delete - DELETE --> \books\{id}
    * Create - POST --> \books
    * Update (replace) - PUT --> \books\{id}
    * Update (partial) - PATCH --> \books\{id}
    

REST
* HTTP
* JSON
* CRUD na HTTP
    * hierarchiczne adresy
    * Read - GET --> \books
    * Read on - GET -->\books\{id}
    * Delete - DELETE --> \books\{id}
    * Create - POST --> \books
    * Update (replace) - PUT --> \books\{id}
    * Update (partial) - PATCH --> \books\{id}
    

    

REST
* HTTP
* JSON
* CRUD na HTTP
    * hierarchiczne adresy
    * Read - GET --> \books
    * Read on - GET -->\books\{id}
    * Delete - DELETE --> \books\{id}
    * Create - POST --> \books
    * Update (replace) - PUT --> \books\{id}
    * Update (partial) - PATCH --> \books\{id}
    
* Exemple API
  * GET --> \items
  * GET --> \items\{id}
  * GET --> \categories\{id}
  
  * GET --> \categories
  * GET --> \categories\{id}
  * GET --> \categories\{id}\items