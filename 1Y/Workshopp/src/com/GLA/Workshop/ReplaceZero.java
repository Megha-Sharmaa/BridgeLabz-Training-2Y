package com.GLA.Workshop;

public class ReplaceZero {
    public static void main(String[] args) {
        int num = 102030;
        String str = String.valueOf(num);
        str = str.replace('0', '1');
        int result = Integer.parseInt(str);
        System.out.println("Original number: " + num);
        System.out.println("After replacing 0s with 1s: " + result);
    }
}
