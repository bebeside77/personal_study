package com.may.java.ctci;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author bebeside77
 */
public class ArchiveStringTest {
    private ArchiveString archiveString = new ArchiveString();

    @Test
    public void archiveString() throws Exception {
        String result = archiveString.archiveString("aabccccccccaaa");
        assertThat(result, is("a2b1c8a3"));
    }


}