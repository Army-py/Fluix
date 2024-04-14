# Fluix

A simple BungeeCord plugin that lets you create as many private chats as you like

## Commands

- `/fluixreload` - Reload the plugin
  - Aliases: `/fluixrl`
  - Permission: `fluix.reload`

## Config

```yaml

# Default available language :
# en_us - English (United States)
# fr_fr - French (France)
language: "en_us"

chat:
#  anyname:
#    command: "your_command"
#    aliases:
#      - "your_alias"
#    prefix: "§8[§6§lYour Chat Name§8] "
#    format: "{PREFIX} §7{PLAYER} §8» §7{MESSAGE}"
#    permission:
#      write: "fluix.chat.your_command.write"
#      read: "fluix.chat.your_command.read"
  default:
    command: "default"
    aliases:
      - "d"
    prefix: "§8[§6§lDefault§8] "
    format: "{PREFIX} §7{PLAYER} §8» §7{MESSAGE}"
    permission:
      write: "fluix.chat.default.write"
      read: "fluix.chat.default.read"


# Placeholders :
# Placeholders are used to replace the value with the actual value.
# It is only available in the format section.
# {PLAYER} - Player name
# {MESSAGE} - Message to be sent
# {PREFIX} - Prefix of the chat
# {SERVER} - Server name where the message is sent
```

## Language

### en_us.yml
```yaml

# List of available placeholders
# {CHAT_COMMAND} - Chat command used name

FLUIX_CHAT_USAGE: "§cUsage: /{CHAT_COMMAND} <message>"
NO_PERMISSION: "§cYou do not have permission to use this command."
RELOADED: "§aConfiguration reloaded."

```

### fr_fr.yml
```yaml

# List of available placeholders
# {CHAT_COMMAND} - Chat command used name

FLUIX_CHAT_USAGE: "§cUtilisation: /{CHAT_COMMAND} <message>"
NO_PERMISSION: "§cVous n'avez pas la permission d'utiliser cette commande."
RELOADED: "§aConfiguration rechargée."

```
