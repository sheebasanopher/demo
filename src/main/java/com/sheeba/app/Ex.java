package com.sheeba.app;

import java.util.stream.Stream;

public class Ex {
    public static void main(String[] arg) {
        String s = "welcome";
        String s1 = "welcome";
        if (s.equals(s1)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        String string = new String("rose");
        String string2 = new String("rose");
        if (string.equals(string2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        StringBuffer b = new StringBuffer("hanif");
        StringBuffer b1 = new StringBuffer("hanif");
        if (b.equals(b1)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        s = s.concat("moon");
        System.out.println(s);

        String st = new String("guru");
        System.out.println(st);

        StringBuilder builder = new StringBuilder("duck");
        StringBuffer buffer = new StringBuffer("jack");
        builder = builder.append("duck");
        System.out.println(buffer);
        System.out.println(builder);


        Stream.iterate(1, element->element++)
                .filter(element->element%2==0)
                .limit(10)
                .forEach(System.out::println);


    }
}
