package day4;

import java.util.HashMap;
import java.util.Map;

// 2026-10-10
// #383 Leetcode
// Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//
// Each letter in magazine can only be used once in ransomNote.
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {

            Map<Character, Integer> map = new HashMap<>();

            for (char c : ransomNote.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (char c : magazine.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) - 1);
            }

            return map.values().stream().noneMatch(v -> v > 0);

    }

    public boolean canConstruct2(String ransomNote, String magazine){
        int[] count = new int[26];

        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : magazine.toCharArray()) {
            count[c - 'a']--;
        }

        for (int v : count) {
            if (v > 0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.canConstruct("a", "b"));
        System.out.println(ransomNote.canConstruct("aa", "ab"));
        System.out.println(ransomNote.canConstruct("aa", "aab"));

        System.out.println(ransomNote.canConstruct2("a", "b"));
        System.out.println(ransomNote.canConstruct2("aa", "ab"));
        System.out.println(ransomNote.canConstruct2("aa", "aab"));

    }
}
