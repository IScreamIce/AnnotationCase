package com.kaige123.daomu.frameword.FindRegService;

import java.io.File;
import java.net.URL;

public class FindService {

    /**
     * 判断扫描注解的服务包是否存在
     *
     * @throws Exception
     */
    public static File FindPathService() throws Exception {
        //得到工程路径
        Class aClass = FindService.class;
        URL resource = aClass.getClassLoader().getResource("");
        String path = resource.getFile().substring(0, resource.getFile().indexOf("target") + 7) + "classes/";
        System.out.println("thisPath:\t\t " + path+"\n");

        //得到包
        String replace = ParamterConfig.basepath;

        System.out.println("thisPackage:\t " + replace+"\n");

        //判断包是否存在
        File file = new File(path, replace);

        if (file.exists()) {
            System.out.println("ISFileExist:\t Package[service]OK"+"\n");
            return file;
        } else {
            throw new Exception("ISFileExist:\t FilePackage[service]NoExists");
        }
    }

}
