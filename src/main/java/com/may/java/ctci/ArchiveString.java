package com.may.java.ctci;

/**
 * @author bebeside77
 */
public class ArchiveString {

    public String archiveString(String inputStr) {
        StringBuilder sb = new StringBuilder();
        int dupCnt = 0;

        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i);

            if (i > 0 && inputStr.charAt(i - 1) == c) {
                dupCnt++;
            } else {
                if (dupCnt > 0) {
                    sb.append(dupCnt);
                }

                sb.append(c);
                dupCnt = 1;
            }

            if (i == inputStr.length() - 1) {
                sb.append(dupCnt);
            }

            if (sb.toString().length() >= inputStr.length()) {
                return inputStr;
            }
        }

        return sb.toString();
    }

}
