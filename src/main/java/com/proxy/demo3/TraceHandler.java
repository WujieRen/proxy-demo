package com.proxy.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>
 * </p>
 *
 * @author renwujie
 * @since 2018-10-29 15:18
 */
public class TraceHandler implements InvocationHandler {

    private Object target;

    TraceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        if(null != args) {
            for(int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if(i < args.length - 1) System.out.print(",");
            }
        }
        System.out.println(")");
        return method.invoke(target, args);
    }
}
