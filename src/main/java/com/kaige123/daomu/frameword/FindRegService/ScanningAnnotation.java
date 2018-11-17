package com.kaige123.daomu.frameword.FindRegService;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.*;

public class ScanningAnnotation {

    private static Map<String, Class> classes = new HashMap<String, Class>();

    public static Map<String, Class> ScanningClassAnnotation(File file) throws ClassNotFoundException {
        String[] list = file.list();
        System.out.println("File List: " + Arrays.toString(list) + "\n");

        for (String s : list) {
            String substring = s.substring(0, s.lastIndexOf("."));
            Class aClass = Class.forName(ParamterConfig.basepackage + "." + substring);
            Annotation[] annotations = aClass.getAnnotations();
            for (Annotation annotation : annotations) {
                String toString = annotation.toString();
                if (toString.indexOf("Servlet") >= 0) {
                    String key = toString.substring(toString.indexOf("value") + 7, toString.length() - 1);
                    classes.put(key, aClass);
                }
            }
        }
        return classes;
    }
}
