package fr.army.fluix.config.message;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class PlaceholdersUtils {

    public static String replace(@NotNull String input, @NotNull Map<Placeholders, String> value) {
        for (Placeholders placeholder : value.keySet()) {
            input = input.replace("{" + placeholder.toString() + "}", value.get(placeholder));
        }

        return input;
    }
}
