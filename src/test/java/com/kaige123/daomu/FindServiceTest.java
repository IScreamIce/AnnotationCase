package com.kaige123.daomu;

import com.kaige123.daomu.frameword.FindRegService.FindService;
import com.kaige123.daomu.frameword.FindRegService.InvokePrint;
import com.kaige123.daomu.frameword.FindRegService.ScanningAnnotation;
import com.kaige123.daomu.service.server;
import com.kaige123.daomu.service.serverIF;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class FindServiceTest {

    @Test
    public void fidtest() throws Exception {
        //得到服务包下所有服务类
        File file = FindService.FindPathService();
        System.out.println("return FilePath: " + file + "\n");

        //得到类的所有注解,返回<value,class>
        Map<String, Class> classes = ScanningAnnotation.ScanningClassAnnotation(file);
        if (classes.keySet().size() > 0) {
            System.out.println("classes key: " + classes.keySet().iterator().next());
            System.out.println("classes value: " + classes.values().iterator().next() + "\n");
        }

        //模拟客户请求服务
        //uri ihandle 有处理者
        if (classes.containsKey("ihandle")) {
            Class<?> ihandle = Class.forName(classes.get("ihandle").getName());
            Object o = ihandle.newInstance();
            Method doGet = ihandle.getMethod("doGet", null);
            doGet.invoke(o);
        }
        //uri ihandle 无处理者
        if (classes.containsKey("ihandlex")) {
        } else {
            System.out.println("ihandlex: 没有处理者 404" + "\n");
        }

        server server = new server();
        System.out.println("server hashCode: " + server.hashCode() + "\n");
        serverIF serverIF = (serverIF) Proxy.newProxyInstance(
                Class.forName(classes.get("ihandle").getName()).getClassLoader(),
                Class.forName(classes.get("ihandle").getName()).getInterfaces(),
                new InvokePrint(server));

        serverIF.doGet();
    }
}
