package com.four.fvs.goeasy;

import io.goeasy.GoEasy;
import org.junit.Test;

public class goeasyTest {
    @Test
    public void goEasyTest() {
        GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io/publish", "BC-ba1fdee766924b6ab8b658f2a2c23645");
        goEasy.publish("test1", "Hello, GoEasy!");
    }
}
