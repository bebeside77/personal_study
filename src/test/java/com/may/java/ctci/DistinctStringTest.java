package com.may.java.ctci;

import org.junit.Test;
import org.mockito.InjectMocks;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author bebeside77
 */
public class DistinctStringTest {
    @InjectMocks
    private DistinctString distinctString = new DistinctString();

    @Test
    public void isDistinct() throws Exception {
        assertThat(distinctString.isDistinct("abcdef"), is(true));
        assertThat(distinctString.isDistinct("abcdd"), is(false));
        assertThat(distinctString.isDistinct("12344"), is(false));
    }


}