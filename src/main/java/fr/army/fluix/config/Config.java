package fr.army.fluix.config;

import fr.army.fluix.chat.FluixChat;
import net.md_5.bungee.config.Configuration;

import java.util.Map;
import java.util.stream.Collectors;

public class Config {

    private final Configuration config;

    public static Map<String, FluixChat> chats;

    public Config(Configuration config) {
        this.config = config;
    }

    public void load() {
        chats = loadChats();
    }

    private Map<String, FluixChat> loadChats() {
        Configuration chatSection = config.getSection("chats");
        return chatSection.getKeys().stream()
                .collect(Collectors.toMap(
                                key -> key,
                                key -> new FluixChat.Builder()
                                        .setCommand(chatSection.getString(key + ".command"))
                                        .setAliases(chatSection.getStringList(key + ".aliases"))
                                        .setPrefix(chatSection.getString(key + ".prefix"))
                                        .setFormat(chatSection.getString(key + ".format"))
                                        .setWritePermission(chatSection.getString(key + ".permission.write"))
                                        .setReadPermission(chatSection.getString(key + ".permission.read"))
                                        .build()
                        )
                );
    }
}
