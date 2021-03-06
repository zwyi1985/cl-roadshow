package com.cl.roadshow.java.lang.classinfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据类型判断
 * 
 */
public class TypeDemo {
    private static final Logger log = LoggerFactory.getLogger("console");

    public static void main(String[] args) {
        Object o = 1.2;
        log.info("o instanceof Long:{}",(o instanceof Long));
        log.info("o instanceof Integer:{}",(o instanceof Integer));
        log.info("o instanceof Short:{}",(o instanceof Short));
        log.info("o instanceof Byte:{}",(o instanceof Byte));
        log.info("o instanceof Double:{}",(o instanceof Double));
        log.info("o instanceof Float:{}",(o instanceof Float));
        log.info("o.getClass().getName():{}",(o.getClass().getName()));
        
        // java.lang.Double cannot be cast to java.lang.Integer
        //Integer i = (Integer)o;
        //log.info("i:{}",i);
        
        log.info("confuseNumber((long)3):{}",confuseNumber((long)3));
        log.info("confuseNumber(3):{}",confuseNumber(3));
        log.info("confuseNumber((short)3):{}",confuseNumber((short)3));
        log.info("confuseNumber((byte)3):{}",confuseNumber((byte)3));
        log.info("confuseNumber(3.3):{}",confuseNumber(3.0));
        log.info("confuseNumber((float)3.3):{}",confuseNumber((float)3));
        
        Double a = 1.0;
        Double b = 1.0;
        log.info("a==b : " + (a==b));
    }
    
    private static Object confuseNumber(Object o) {
        Double d = Double.parseDouble(o.toString());
        d = d + 10;
        switch(o.getClass().getName()) {
            case "java.lang.Long":
                return d.longValue();
            case "java.lang.Integer":
                return d.intValue();
            case "java.lang.Short":
                return d.shortValue();
            case "java.lang.Byte":
                return d.byteValue();
            case "java.lang.Double":
                return d;
            case "java.lang.Float":
                return d.floatValue();
            default:
                return o;
        }
    }
}