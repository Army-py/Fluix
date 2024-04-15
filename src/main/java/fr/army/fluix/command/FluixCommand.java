package fr.army.fluix.command;

import fr.army.fluix.Fluix;
import fr.army.fluix.chat.FluixChat;
import fr.army.fluix.config.message.Messages;
import fr.army.fluix.config.message.Placeholders;
import fr.army.fluix.config.message.PlaceholdersUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class FluixCommand extends Command {

    private final FluixChat chat;

    public FluixCommand(@NotNull FluixChat chat) {
        super(
                chat.getCommand(),
                chat.getWritePermission(),
                chat.getAliases().toArray(new String[0])
        );
        this.chat = chat;
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (!(commandSender instanceof ProxiedPlayer player)) return;

        if (!player.hasPermission(chat.getWritePermission())) {
            player.sendMessage(new TextComponent(Messages.NO_PERMISSION.getMessage()));
            return;
        }

        if (strings.length == 0) {
            final Map<Placeholders, String> replacements = Map.of(
                    Placeholders.CHAT_COMMAND, chat.getCommand()
            );
            player.sendMessage(new TextComponent(Messages.FLUIX_CHAT_USAGE.getMessage(replacements)));
            return;
        }

        final StringBuilder message = new StringBuilder();
        for (String string : strings) {
            message.append(string).append(" ");
        }

        final Map<Placeholders, String> replacements = Map.of(
                Placeholders.PREFIX, chat.getPrefix(),
                Placeholders.PLAYER, player.getName(),
                Placeholders.SERVER, player.getServer().getInfo().getName(),
                Placeholders.MESSAGE, message.toString()
        );

        for (ProxiedPlayer proxiedPlayer : Fluix.getPlugin().getProxy().getPlayers()) {
            if (proxiedPlayer.hasPermission(chat.getReadPermission())) {
                proxiedPlayer.sendMessage(new TextComponent(PlaceholdersUtils.replace(chat.getFormat(), replacements)));
            }
        }
    }

    public FluixChat getChat() {
        return chat;
    }
}
