package com.practice.random;

import java.util.HashMap;
import java.util.Map;

public class GoodBinaryString {

    // 1. 1's should be greater than equal to 0's in each pattern
    
    public static void main(String[] args) {
        String binary = "110001011";

        boolean isBinary = split(binary, 0, true);
        System.out.println(isBinary);
    }

    private static boolean split(String str, int len, boolean isValid) {
        int ones = 0;
        int zeroes = 0;
        while (len != str.length()) {
            String subStr = str.substring(0, len + 1);
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < subStr.length(); i++) {
                if (subStr.charAt(i) == '1') {
                    map.put(subStr.charAt(i), ones + 1);
                    ones += 1;
                } else {
                    map.put(subStr.charAt(i), zeroes + 1);
                    zeroes += 1;
                }
            }
            if (map.getOrDefault('1', 0) < map.getOrDefault('0', 1)) {
                isValid = false;
            }
            len++;

        }
        return isValid;
    }


}
