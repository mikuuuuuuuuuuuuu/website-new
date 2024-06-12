package com.chugest.schedule.test;

import com.chugest.schedule.util.MD5Util;
import org.junit.Test;

//测试MD5Util
public class TestMD5Util {
    @Test
    public void testEncrypt(){
        String encrypt=MD5Util.encrypt("12345678");
        System.out.println(encrypt);
    }
}
