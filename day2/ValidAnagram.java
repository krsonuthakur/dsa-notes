package day2;

import java.util.HashMap;
import java.util.Map;

// #242 Leetcode
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = getCharMapFromString(s);
        Map<Character, Integer> tMap = getCharMapFromString(t);

        if (sMap.equals(tMap)) {
            return true;
        }

        return false;
    }

    private Map<Character, Integer> getCharMapFromString(String s) {
        Map<Character, Integer> resultMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            resultMap.put(c, resultMap.getOrDefault(c, 0) + 1);
        }
        return resultMap;
    }

    public static void main(String args[]) {
        ValidAnagram va = new ValidAnagram();
        Boolean result = va.isAnagram("aabbc", "abbcc");
        System.out.println(result);

        System.out.println(va.isAnagramModified("aabbc", "abbcc"));
        System.out.println(va.isAnagramModified("anagram", "nagaram"));
    }

    // got below after review from ChatGpt
    public boolean isAnagramModified(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        return map.values().stream().allMatch(v -> v == 0);
    }
}
