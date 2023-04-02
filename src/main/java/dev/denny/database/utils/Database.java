package dev.denny.database.utils;

import dev.denny.database.DatabasePlugin;
import lombok.Getter;
import me.hteppl.data.database.MySQLDatabase;
import org.sql2o.Connection;

public class Database extends MySQLDatabase {

    @Getter
    private final Connection connection;

    public Database(String host, String database, String user, String password) {
        //Передаём родителю данные для поключения к базе данных
        super(
                DatabasePlugin.getConfigManager().getHost(),
                DatabasePlugin.getConfigManager().getDatabase(),
                DatabasePlugin.getConfigManager().getUser(),
                DatabasePlugin.getConfigManager().getPassword()
        );
    
        //Устанавливаем соединение с базой данных
        try (Connection connection = this.openConnection()) {
            this.connection = connection;
        }
    }
}