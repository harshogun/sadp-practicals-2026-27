
package com.harsh.sadp.adapter;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        Vector<String> languages = new Vector<>();

        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("JavaScript");

        Enumeration<String> enumeration =
                languages.elements();

        Iterator<String> iterator =
                new EnumerationIterator<>(enumeration);

        System.out.println("Languages:");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
