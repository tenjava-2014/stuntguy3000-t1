package com.tenjava.entries.stuntguy3000.t1.util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    /**
     * Removes the specified index from a String array
     *
     * @param array Array to be modified
     * @param index Index to be removed
     * @return String[]
     */
    public static String[] removeIndex(String[] array, int index) {
        List<String> indexList = Arrays.asList(array);

        try {
            indexList.remove(array[index]);
        } catch (IndexOutOfBoundsException ignored) {

        }

        return (String[]) indexList.toArray();
    }
}
    