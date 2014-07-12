package com.tenjava.entries.stuntguy3000.t1.util;

import org.bukkit.ChatColor;

public class Message {
    public static final String COMMAND_HELP = "&7/%s &e%s %s &8- &7%s";
    public static final String COMMAND_HELP_TLTE = "&6FireFlight Command List:";
    public static final String COMMAND_INFO_DESCRIPTION = "&7Description: &e%s";
    public static final String COMMAND_INFO_INVALID = "&cInvalid ability specified!";
    public static final String COMMAND_INFO_NAME = "&7Name: &e%s";
    public static final String ERROR_COMMAND_UNSUPPORTED_CONSOLE = "&cOnly Players can run this command!";
    public static final String ERROR_INVALID_COMMAND = "&cThat command cannot be found!";
    public static final String ERROR_INVALID_PLAYER = "&cThat player cannot be found!";
    public static final String ERROR_INVALID_SYNTAX = "&cCorrect Syntax: /%s %s %s";
    public static final String ERROR_COOLDOWN = "&cThis Bow is still reloading! (%s second(s))...";
    public static final String ERROR_NO_PERMISSION = "&cYou do not have permission to do this action!";
    public static final String GENERAL_PREFIX = "&8[&6FireFlight&8] ";
    public static final String INVENTORY_TITLE = "&1Choose a Bow";

    /**
     * Formulate a String, and its variables into a Message to be sent to a Player
     *
     * @param message   message String to be formatted
     * @param variables variables Array of values to be formatted
     * @return formulated result
     */
    public static String formulate(String message, Object... variables) {
        return ChatColor.translateAlternateColorCodes('&', GENERAL_PREFIX + String.format(message, variables));
    }

    /**
     * Formulate a String, and its variables into a Message to be sent to the Console </p> This method removes any
     * ChatColor symbols
     *
     * @param message   message String to be formatted
     * @param variables variables Array of values to be formatted
     * @return formulated result
     */
    public static String formulateConsole(String message, Object... variables) {
        return ChatColor.stripColor(formulate(message, variables));
    }

    /**
     * Formulate a String, and its variables into a Message to be sent to a Player </p> This method does not add the
     * GENERAL_PREFIX message.
     *
     * @param message   message String to be formatted
     * @param variables variables Array of values to be formatted
     * @return formulated result
     */
    public static String formulateRaw(String message, Object... variables) {
        return ChatColor.translateAlternateColorCodes('&', String.format(message, variables));
    }
}
    