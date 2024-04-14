package fr.army.fluix.command;

import fr.army.fluix.Fluix;
import fr.army.fluix.config.message.Messages;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ReloadCommand extends Command {

    public ReloadCommand(String name, String permission, String... aliases) {
        super(name, permission, aliases);
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (!(commandSender instanceof ProxiedPlayer player)) return;

        if (!player.hasPermission(getPermission())) {
            player.sendMessage(new TextComponent(Messages.NO_PERMISSION.getMessage()));
            return;
        }

        Fluix.getPlugin().load(true);
        player.sendMessage(new TextComponent("§aReloaded!"));
    }
}
