package com.xf.mvcp.test;

import com.xf.mvcp.utils.C3P0Utils;
import org.junit.Test;

/**
 * C3P0Utils测试类
 */
public class C3P0UtilsTest {
    @Test
    public void testGetConnection(){
        System.out.println(C3P0Utils.getConnection());
    }
}
