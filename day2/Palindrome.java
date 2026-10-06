package day2;

public class Palindrome {
    // ChatGpt says not best, as O(n) time and sapce is used
    public boolean isPalindromeOld(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();

        return cleaned.equals(reversed);
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Best
    public boolean isPalindrome3(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }

            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String args[]) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindromeOld("A man, a plan, a canal: Panama"));
        System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(palindrome.isPalindrome3("A man, a plan, a canal: Panama"));
    }
}
