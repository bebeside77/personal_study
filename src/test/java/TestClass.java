/*
 * @(#)TestClass.java  2016.07.13
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.when;

/**
 * @author yuwook
 */
@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class TestClass {
    @InjectMocks
    private Sut sut = new Sut();

    @Mock
    private Clock clock;

    @Test
    public void testName() throws Exception {
        when(clock.doIt()).thenAnswer(new Answer<String>() {
            int count = 0;

            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                if (count == 2) {
                    throw new RuntimeException("test");
                } else {
                    count++;
                    return "stubbed value";
                }
            }
        });

        sut.doSomething();

    }
}

@Slf4j
class Sut {
    private Clock clock = new Clock();

    public void doSomething() {
        log.info(clock.doIt());
        log.info(clock.doIt());
        log.info(clock.doIt());
    }

}

@Slf4j
class Clock {
    public String doIt() {
        log.info("do It!");
        return "doIt";
    }
}