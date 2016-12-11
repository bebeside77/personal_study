package com.may.java.ctci;

/**
 * 1.3
 *
 * @author bebeside77
 */
public class SpaceReplace {

    public String spaceReplace(String str, int size) {
        StringBuilder sb = new StringBuilder();

        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            char aChar = str.charAt(i);

            if (aChar == ' ') {
                sb.append("%20");
            } else {
                sb.append(aChar);
            }
        }

        return sb.toString();
    }
}
