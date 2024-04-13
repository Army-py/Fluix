package fr.army.fluix.chat;

import fr.army.fluix.command.FluixCommand;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class FluixChat {

    private final String command;
    private final List<String> aliases;
    private final String prefix;
    private final String format;
    private final String writePermission;
    private final String readPermission;

    private FluixChat(
            @NotNull String command,
            @NotNull List<String> aliases,
            @NotNull String prefix,
            @NotNull String format,
            @NotNull String WritePermission,
            @NotNull String readPermission) {
        this.command = Objects.requireNonNull(command, "command");
        this.aliases = Objects.requireNonNull(aliases, "aliases");
        this.prefix = Objects.requireNonNull(prefix, "prefix");
        this.format = Objects.requireNonNull(format, "format");
        this.writePermission = Objects.requireNonNull(WritePermission, "write_permission");
        this.readPermission = Objects.requireNonNull(readPermission, "read_permission");
    }

    public String getCommand() {
        return command;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getFormat() {
        return format;
    }

    public String getWritePermission() {
        return writePermission;
    }

    public String getReadPermission() {
        return readPermission;
    }

    public FluixCommand initCommand() {
        return new FluixCommand(this);
    }


    public static class Builder {
        private String command;
        private List<String> aliases;
        private String prefix;
        private String format;
        private String writePermission;
        private String readPermission;

        public Builder setCommand(@NotNull String command) {
            this.command = command;
            return this;
        }

        public Builder setAliases(@NotNull List<String> aliases) {
            this.aliases = aliases;
            return this;
        }

        public Builder setPrefix(@NotNull String prefix) {
            this.prefix = prefix;
            return this;
        }

        public Builder setFormat(@NotNull String format) {
            this.format = format;
            return this;
        }

        public Builder setWritePermission(@NotNull String writePermission) {
            this.writePermission = writePermission;
            return this;
        }

        public Builder setReadPermission(@NotNull String readPermission) {
            this.readPermission = readPermission;
            return this;
        }

        public FluixChat build() {
            return new FluixChat(command, aliases, prefix, format, writePermission, readPermission);
        }
    }
}
