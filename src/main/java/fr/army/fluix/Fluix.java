package fr.army.fluix;

import fr.army.fluix.command.FluixCommandManager;
import fr.army.fluix.config.Config;
import fr.army.fluix.config.ConfigLoader;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

import java.io.IOException;

public final class Fluix extends Plugin {

    public static Fluix plugin;

    private ConfigLoader configLoader;
    private Config config;
    private Configuration languageConfig;
    private FluixCommandManager commandManager;

    @Override
    public void onEnable() {
        plugin = this;

        configLoader = new ConfigLoader(this);

        load(false);

        getLogger().info("Fluix enabled");
    }

    @Override
    public void onDisable() {
        commandManager.unregisterCommands();

        getLogger().info("Fluix disabled");
    }

    public static Fluix getPlugin() {
        return plugin;
    }

    public ConfigLoader getConfigLoader() {
        return configLoader;
    }

    public Config getConfig() {
        return config;
    }

    public Configuration getLanguageConfig() {
        return languageConfig;
    }

    public FluixCommandManager getCommandManager() {
        return commandManager;
    }


    public void load(boolean isReload) {
        try {
            config = new Config(configLoader.initFile("config.yml"));
            config.load();
        } catch (Exception e) {
            getLogger().severe("Unable to load config.yml");
            getProxy().getPluginManager().unregisterListeners(this);
            return;
        }

        try {
            languageConfig = configLoader.initFile("lang/" + Config.language + ".yml");
        } catch (Exception e) {
            getLogger().severe("Unable to load " + Config.language + ".yml");
            getProxy().getPluginManager().unregisterListeners(this);
            return;
        }

        if (isReload)
            commandManager.reloadCommands();
        else {
            commandManager = new FluixCommandManager(this);
            commandManager.registerCommands();
        }
    }
}
