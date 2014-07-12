package com.tenjava.entries.stuntguy3000.t1.util;

import org.bukkit.ChatColor;

public class Message {
    public static final String ERROR_COMMAND_UNSUPPORTED_CONSOLE = "&cOnly Players can run this command!";
    public static final String ERROR_INVALID_COMMAND = "&cThat command cannot be found!";
    public static final String ERROR_INVALID_SYNTAX = "&cCorrect Syntax: /%s %s %s";
    public static final String GENERAL_PREFIX = "&8[&6FireFlight&8] ";
    public static final String GENERAL_PREFIX_CONSOLE = "[FireFlight] ";

    /**
     * Formulate a String, and its variables into a Message to be sent to a Player
     *
     * @param message message String to be formatted
     * @param variables variables Array of values to be formatted
     * @return formulated result
     */
    public static String formulate(String message, Object... variables) {
        return ChatColor.translateAlternateColorCodes('&', GENERAL_PREFIX + String.format(message, variables));
    }

    /**
     * Formulate a String, and its variables into a Message to be sent to the Console
     * </p>
     * This method removes any ChatColor symbols
     *
     * @param message message String to be formatted
     * @param variables variables Array of values to be formatted
     * @return formulated result
     */
    public static String formulateConsole(String message, Object... variables) {
        return ChatColor.stripColor(GENERAL_PREFIX_CONSOLE + formulate(message, variables));
    }
}
    