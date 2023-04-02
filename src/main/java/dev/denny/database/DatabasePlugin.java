package dev.denny.database;

import cn.nukkit.plugin.PluginBase;
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
        database = new Database();
    }
}