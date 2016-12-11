package com.may.java.ctci;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author bebeside77
 */
public class DistinctString {

    public boolean isDistinct(String str) {
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        Collections.sort(list);

        for (int i = 0; i< list.size(); i++) {
            if (i == list.size() - 1) {
                break;
            }

            if (list.get(i) == list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }
}
