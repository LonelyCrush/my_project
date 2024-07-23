package com.xzit.practice.songshan;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author FH11702
 */
public class AboutSplit {

    public static void main(String[] args) {
        String string = "a,b,c,d,e,,,,";

        String[] stringArray = string.split(",");
        // [a, b, c, d, e]
        System.out.println(Arrays.toString(stringArray));


        String[] stringArray2 = string.split(",\\s+");
        // [a,b,c,d,e,,,,]
        System.out.println(Arrays.toString(stringArray2));

        String[] result = string.split(",", -1);
        // [a, b, c, d, e, , , , ]
        System.out.println(Arrays.toString(result));
        for (int i = 0; i < result.length; i++) {
            if (result[i].isEmpty()) {
                result[i] = null;
            }
        }
        // [a, b, c, d, e, null, null, null, null]
        System.out.println(Arrays.toString(result));
    }
}
