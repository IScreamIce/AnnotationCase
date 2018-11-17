package com.kaige123.daomu.service;

import com.kaige123.daomu.frameword.annotation.Servlet;

@Servlet(value = "/ihandle")
public class server implements serverIF{

    public void doGet() {
        System.out.println("Message: " + this.getClass().getName() + " doGet Server\n");
    }
}
