package dev.denny.database.utils;

import lombok.Getter;
import me.hteppl.data.database.MySQLDatabase;
import org.sql2o.Connection;

import java.util.List;

public class Database extends MySQLDatabase {

    @Getter
    private final Connection connection;

    //Устанавливаем конструтор с некоторыми
    public Database(String host, String database, String user, String password) {
        //Передаём родителю данные для поключения к базе данных
        super(host, database, user, password);
    
        //Устанавливаем соединение с базой данных
        try (Connection connection = this.openConnection()) {
            this.connection = connection;
        }
    }

    //Отправить запрос к базе данных с ответом в виде списка из объектов, заполенных данными
    public <T> List<T> query(String request, Class<T> clazz) {
        List<T> readyList = connection.createQuery(request).executeAndFetch(clazz);
        if(!readyList.isEmpty()) {
            return readyList;
        }
        return null;
    }

    //Отправить запрос к базе данных без ответа
    public void query(String request) {
        connection.createQuery(request).executeUpdate();
    }
}