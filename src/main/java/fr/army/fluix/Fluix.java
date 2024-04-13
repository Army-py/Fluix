package fr.army.fluix;

import fr.army.fluix.command.FluixCommandManager;
import fr.army.fluix.config.Config;
import fr.army.fluix.config.ConfigLoader;
import net.md_5.bungee.api.plugin.Plugin;

public final class Fluix extends Plugin {

    public static Fluix plugin;

    private ConfigLoader configLoader;
    private Config config;
    private FluixCommandManager commandManager;

    @Override
    public void onEnable() {
        plugin = this;

        configLoader = new ConfigLoader(this);

        try {
            config = new Config(configLoader.initFile("config.yml"));
            config.load();
        } catch (Exception e) {
            getLogger().severe("Unable to load config.yml");
            getProxy().getPluginManager().unregisterListeners(this);
            return;
        }

        // Load commands
        commandManager = new FluixCommandManager(this);
        commandManager.registerCommands();

    }

    @Override
    public void onDisable() {

    }

    public ConfigLoader getConfigLoader() {
        return configLoader;
    }

    public Config getConfig() {
        return config;
    }

    public FluixCommandManager getCommandManager() {
        return commandManager;
    }
}
