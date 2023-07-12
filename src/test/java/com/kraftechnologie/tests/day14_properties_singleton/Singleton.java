package com.kraftechnologie.tests.day14_properties_singleton;

import org.testng.annotations.Test;

public class Singleton {
    //tasarım modeli demektir
    private Singleton() {
    }

    private static String str;

    public static String getInstance() {
        if (str == null) {
            System.out.println("str is null, assigning a value to it");
            str = "some value";
        } else {
            System.out.println("it has value,just returning it");
        }
return str;
    }
}
