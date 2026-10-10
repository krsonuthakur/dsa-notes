package day4;

// Leetcode #387
// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
public class FirstUniqueChar {
    public int firstUniqChar(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        FirstUniqueChar fuc = new FirstUniqueChar();

        System.out.println(fuc.firstUniqChar("leetcode"));
        System.out.println(fuc.firstUniqChar("loveleetcode"));
        System.out.println(fuc.firstUniqChar("aabb"));
    }
}
