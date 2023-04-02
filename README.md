# Database - plugin for PowerNuikkitX.
Designed to create a database connection

## How using
Add this code in plugin
```java
//Add a import to class
import dev.denny.database.DatabasePlugin;

DatabasePlugin.getDatabase(); //Returned a Database class extends MySQLDatabase
```
## Configuration of plugin
This plugin adds configuration for itself.  
It creates a folder identical to the name of the plugin and inside this folder the configuration itself.  
The configuration has the following structure:
```yml
#Add a you address
host: value
#Add a you name of database
database: value
#Add a you name of user database
user: value
#Add a you password of user database
password: value
```

## Dependencies
- Need a [DataManager](github.com/hteppl/DataManager)
P. S. this plugin is located in the directory lib
