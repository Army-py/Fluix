package fr.army.fluix.config.message;

import fr.army.fluix.Fluix;
import net.md_5.bungee.config.Configuration;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public enum Messages {

    FLUIX_CHAT_USAGE,
    NO_PERMISSION,
    RELOADED
    ;

    public String getMessage() {
        final Fluix plugin = Fluix.getPlugin();
        final Configuration messages = plugin.getLanguageConfig();

        final String message = messages.getString(this.toString());
        if (message == null){
            plugin.getLogger().warning("Missing message: " + this.toString());
            return " ";
        }

        return message;
    }

    public String getMessage(@NotNull Map<Placeholders, String> args) {
        final Fluix plugin = Fluix.getPlugin();
        final Configuration messages = plugin.getLanguageConfig();

        String message = messages.getString(this.toString());
        if (message == null){
            plugin.getLogger().warning("Missing message: " + this.toString());
            return " ";
        }

        return PlaceholdersUtils.replace(message, args);
    }

}
