package fr.army.fluix.command;

import fr.army.fluix.Fluix;
import fr.army.fluix.chat.FluixChat;
import fr.army.fluix.config.Config;

public class FluixCommandManager {

    private final Fluix fluix;

    public FluixCommandManager(Fluix fluix) {
        this.fluix = fluix;
    }

    public void registerCommands() {
        for (FluixChat chat : Config.chats.values()) {
            fluix.getProxy().getPluginManager().registerCommand(fluix, chat.initCommand());
            fluix.getLogger().info("Registered command: " + chat.getCommand());
        }
    }

    public void unregisterCommands() {
        fluix.getProxy().getPluginManager().unregisterCommands(fluix);
    }

    public void reloadCommands() {
        unregisterCommands();
        registerCommands();
    }

    public Fluix getFluix() {
        return fluix;
    }
}
