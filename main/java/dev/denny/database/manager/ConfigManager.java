package dev.denny.database.manager;

import cn.nukkit.plugin.Plugin;
import cn.nukkit.utils.Config;
import lombok.Getter;

import java.io.File;

public class ConfigManager {

    @Getter
    private final File file;

    @Getter
    private final Config config;

    @Getter
    public final String host;

    @Getter
    public final String database;

    @Getter
    public final String user;

    @Getter
    public final String password;

    public ConfigManager(Plugin plugin) {
        file = new File(plugin.getDataFolder(), "/config.yml");
        config = new Config(file, Config.YAML);

        addDefaultParameters();

        host = config.getString("host");
        database = config.getString("database");
        user = config.getString("user");
        password = config.getString("password");
    }

    public void addDefaultParameters() {
        this.addDefault("host", "value");
        this.addDefault("database", "value");
        this.addDefault("user", "value");
        this.addDefault("password", "value");
    }

    public void addDefault(String path, Object object){
        if(!config.exists(path)){
            config.set(path, object);
            config.save(file);
        }
    }
}