package fr.army.fluix.command;

import fr.army.fluix.chat.FluixChat;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import org.jetbrains.annotations.NotNull;

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
            player.sendMessage(new TextComponent("§cYou do not have permission to use this command."));
            return;
        }

        if (strings.length == 0) {
            player.sendMessage(new TextComponent("§cUsage: /" + chat.getCommand() + " <message>"));
            return;
        }

        StringBuilder message = new StringBuilder();
        for (String string : strings) {
            message.append(string).append(" ");
        }

        player.sendMessage(new TextComponent(chat.getPrefix() + " " + message));

        for (ProxiedPlayer proxiedPlayer : player.getServer().getInfo().getPlayers()) {
            if (proxiedPlayer.hasPermission(chat.getReadPermission())) {
                proxiedPlayer.sendMessage(new TextComponent(chat.getPrefix() + " " + message));
            }
        }
    }

    public FluixChat getChat() {
        return chat;
    }
}
