package com.tenjava.entries.stuntguy3000.t1.util;

public class Perm {
    public static final String COMMAND_GIVE = "fireflight.command.give";
    public static final String COMMAND_INFO = "fireflight.command.info";
    public static final String COMMAND_SELECT = "fireflight.command.select";
    public static final String GENERAL_BOW_USE = "fireflight.bow.%s";

    /**
     * Format a Permission node
     *
     * @param permission
     * @param arguments
     * @return
     */
    public static String formulate(final String permission, final Object... arguments) {
        return String.format(permission, arguments);
    }
}
    