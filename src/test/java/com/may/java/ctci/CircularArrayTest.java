package com.may.java.ctci;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author bebeside77
 */
public class CircularArrayTest {

    @Test
    public void test() throws Exception {
        CircularArray<String> circularArray = new CircularArray<>();

        circularArray.add("1");
        circularArray.add("2");
        circularArray.add("3");
        circularArray.add("4");
        circularArray.add("5");
        circularArray.add("6");
        circularArray.add("7");
        circularArray.add("8");
        circularArray.add("9");
        circularArray.add("10");

        assertThat(circularArray.get(0), is("1"));

        circularArray.setOffset(3);
        assertThat(circularArray.get(0), is("4"));

        circularArray.setOffset(15);
        assertThat(circularArray.get(0), is("6"));

        circularArray.setOffset(0);
        circularArray.set("60", 5);
        assertThat(circularArray.get(5), is("60"));
    }

    @Test
    public void iterator() throws Exception {
        CircularArray<String> circularArray = new CircularArray<>();

        circularArray.add("1");
        circularArray.add("2");
        circularArray.add("3");
        circularArray.add("4");
        circularArray.add("5");
        circularArray.add("6");
        circularArray.add("7");
        circularArray.add("8");
        circularArray.add("9");
        circularArray.add("10");

        for (String str : circularArray) {
            System.out.println(str);
        }

    }

    @Test
    public void iterator2() throws Exception {
        CircularArray<String> circularArray = new CircularArray<>();

        circularArray.add("1");
        circularArray.add("2");
        circularArray.add("3");
        circularArray.add("4");
        circularArray.add("5");
        circularArray.add("6");
        circularArray.add("7");
        circularArray.add("8");
        circularArray.add("9");
        circularArray.add("10");

        circularArray.setOffset(2);

        for (String str : circularArray) {
            System.out.println(str);
        }

    }
}