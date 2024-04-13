package fr.army.fluix.chat;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class FluixChat {

    private final String command;
    private final List<String> aliases;
    private final String prefix;
    private final String format;
    private final String write_permission;
    private final String read_permission;

    private FluixChat(
            @NotNull String command,
            @NotNull List<String> aliases,
            @NotNull String prefix,
            @NotNull String format,
            @NotNull String write_permission,
            @NotNull String read_permission) {
        this.command = Objects.requireNonNull(command, "command");
        this.aliases = Objects.requireNonNull(aliases, "aliases");
        this.prefix = Objects.requireNonNull(prefix, "prefix");
        this.format = Objects.requireNonNull(format, "format");
        this.write_permission = Objects.requireNonNull(write_permission, "write_permission");
        this.read_permission = Objects.requireNonNull(read_permission, "read_permission");
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

    public String getWrite_permission() {
        return write_permission;
    }

    public String getRead_permission() {
        return read_permission;
    }


    public static class Builder {
        private String command;
        private List<String> aliases;
        private String prefix;
        private String format;
        private String write_permission;
        private String read_permission;

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

        public Builder setWritePermission(@NotNull String write_permission) {
            this.write_permission = write_permission;
            return this;
        }

        public Builder setReadPermission(@NotNull String read_permission) {
            this.read_permission = read_permission;
            return this;
        }

        public FluixChat build() {
            return new FluixChat(command, aliases, prefix, format, write_permission, read_permission);
        }
    }
}
