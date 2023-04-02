package dev.denny.database;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.MainLogger;
import dev.denny.database.manager.ConfigManager;
import dev.denny.database.utils.Database;
import lombok.Getter;

public class DatabasePlugin extends PluginBase {

    @Getter
    public static ConfigManager configManager;

    @Getter
    public static Database database;

    @Override
    public void onEnable() {
        configManager = new ConfigManager(this);

        String host = configManager.getHost();
        String database = configManager.getDatabase();
        String user = configManager.getUser();
        String password = configManager.getPassword();

        MainLogger logger = getServer().getLogger();
        logger.debug("Хост: " + host);
        logger.debug("База данных: " + database);
        logger.debug("Пользователь: " + user);
        logger.debug("Пароль: " + password);
        logger.debug("Пытаюсь установить соединение с базой данных...");

        try {
            this.database = new Database(host, database, user, password);
        } catch (Exception e) {
            logger.emergency("Ошибка! Подключение не было установлено...");
        }
    }
}