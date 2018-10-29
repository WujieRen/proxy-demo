package com.proxy.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * <p>
 * </p>
 *
 * @author renwujie
 * @since 2018-10-29 15:19
 */
public class ProxyTest {
    public static void main(String[] args){
        Object[] elements = new Object[1000];
        //fill elements with proxies for the integer 1 ... 1000
        for(int i = 0; i < 1000; i++) {
            Integer val = i + 1;
            //construct invocation handler
            InvocationHandler handler = new TraceHandler(val);
            //construct proxy for one or more interfaces
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);

            elements[i] = proxy;
        }

        int key = new Random().nextInt(elements.length);         //a random number
        int result = Arrays.binarySearch(elements, key);        //search for the key
        if(result > 0) System.out.println(elements[result]);    //print match if found
    }
}
