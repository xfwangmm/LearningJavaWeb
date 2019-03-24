package com.xf.mvcp.test;

import com.xf.mvcp.utils.StringUtils;
import org.junit.Test;

public class StringUtilsTest {
    @Test
    public void testRemoveIllegalChar(){
        String arg = "dasinsert?::--===*+";
        System.out.println(StringUtils.removeIllegalChar(arg));
    }
}
