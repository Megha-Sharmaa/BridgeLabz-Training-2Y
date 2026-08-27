package com.GLA.Workshop;

import java.util.ArrayList;
import java.util.HashSet;
public class RemoveDuplicate {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Mohan");
        list.add("Sohan");
        list.add("Mohan");
        list.add("Ram");
        list.add("Sohan");
        System.out.println("Original List: " + list);
        HashSet<String> set = new HashSet<>(list);
        ArrayList<String> uniqueList = new ArrayList<>(set);
        System.out.println("List after removing duplicates: " + uniqueList);
    }

}
