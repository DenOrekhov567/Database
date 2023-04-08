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
        logger.info("Host: " + host);
        logger.info("Name of database: " + database);
        logger.info("Name of user: " + user);
        logger.info("Password of user: " + password);
        logger.info("Attempt to set connection with database...");

        try {
            this.database = new Database(host, database, user, password);

            logger.info("Success! Connection seted...");
        } catch (Exception e) {
            logger.emergency("Error! Connection do not be seted...");
        }
    }
}