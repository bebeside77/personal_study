package com.may.java.ctci;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author yuwook
 */
public class SpaceReplaceTest {
    private SpaceReplace spaceReplace = new SpaceReplace();

    @Test
    public void spaceReplace() throws Exception {
        String result = spaceReplace.spaceReplace("Mr John Smith", 13);
        assertThat(result, is("Mr%20John%20Smith"));
    }


}