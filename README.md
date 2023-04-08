# Database - plugin for NukkitX
Designed to create a database connection and send requests

## Examples
Do not forget implementation this librarry in your project
```java
//Add a import to class
package dev.denny.database.DatabasePlugin;

import dev.denny.database.DatabasePlugin;
import dev.denny.database.utils.Database;

public class DatabasePlugin extends PluginBase {

    @Override
    public void onLoad() {
        Database database = DatabasePlugin.getDatabase();
        
        //Let's make a query with a selection of records
        //Returns all records in the form of a list that satisfy the query
        String request = "SELECT * FROM accounts WHERE name = 'nick'";
        List<AccountData> response = database.query(request, AccountData.class);
        //For example. Get the first list of elements
        AccountData accountData = response.get(0);
        
        //Let's make a request with to update the data
        String request = "UPDATE accounts SET name = 'newName' WHERE name = 'oldName'";
        //Returned void
        database.query(request);
    }

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
