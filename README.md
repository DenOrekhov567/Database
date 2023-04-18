# Database
Плагин для создания соединения с базой данных и отправки запросов

## Примеры использования
```java
public class DatabasePlugin extends PluginBase {

    private Database database;
    
    @Override
    public void onLoad() {
        database = DatabasePlugin.getDatabase();
        
        //Получим запись из базы данных в виде объекта Data
        Data data = getData();
        
        //Отправим запрос на обновление записи
        updateData();
    }
    
    private Data getData() {
        //Сделаем запрос с выборкой записей
        String request = "SELECT * FROM accounts WHERE name = 'nick'";
        
        return database.query(request, AccountData.class).get(0);
    }
    
    private void updateData() {
        //Сделаем запрос на обновление данных
        String request = "UPDATE accounts SET name = 'newName' WHERE name = 'oldName'";
        
        database.query(request);
    }

```
## Конфигурация плагина
Этот плагин добавляет конфигурацию для себя  
Он создает папку, идентичную названию плагина, и внутри этой папки сам файл конфигурации  
Конфигурация имеет следующую структуру:
```yml
#Укажите адрес подключения
host: value
#Укажите имя базы данных
database: value
#Укажите имя пользователя
user: value
#Укажите пароль пользователя
password: value
```

## Зависимости
- [DataManager](github.com/hteppl/DataManager)
