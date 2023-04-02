package dev.denny.database.utils;

import dev.denny.database.DatabasePlugin;
import dev.denny.database.manager.ConfigManager;
import lombok.Getter;
import me.hteppl.data.database.MySQLDatabase;
import org.sql2o.Connection;

import java.util.List;

public class Database extends MySQLDatabase {

    @Getter
    private final Connection connection;

    public Database() {
        //Передаём родителю данные для поключения к базе данных
        super(
                DatabasePlugin.getConfigManager().getHost(),
                DatabasePlugin.getConfigManager().getDatabase(),
                DatabasePlugin.getConfigManager().getUser(),
                DatabasePlugin.getConfigManager().getPassword()
        );
    
        //Создаем базу данных с именем project, если её нет
        //Не получится... т.к. подключение инициализируется самым первым и там уже нужна база данных...
        this.executeScheme("CREATE DATABASE IF NOT EXISTS project");
    
        //Устанавливаем соединение с базой данных
        try (Connection connection = this.openConnection()) {
            this.connection = connection;
        }
    }
}