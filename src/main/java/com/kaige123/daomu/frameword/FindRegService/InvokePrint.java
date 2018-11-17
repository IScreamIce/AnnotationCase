package com.kaige123.daomu.frameword.FindRegService;

import com.kaige123.daomu.service.server;

import java.lang.reflect.Method;

public class InvokePrint implements java.lang.reflect.InvocationHandler {

    private final Object o;

    public InvokePrint(Object o) {
        this.o = o;
        System.out.println("server hashCode: " + o.hashCode() + "\n");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke: 收到请求\n");
        o.getClass().getMethod("doGet", null).invoke(o);
        return null;
    }
}
