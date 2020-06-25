package learn.java.codeaccess;

public class Palindrome {

    public static boolean isPalindrome(String str) {
        boolean isPalindrome = true;
        int MIN = 0;
        str = str.replaceAll("[^a-zA-Z]+", "").toUpperCase();
        int MAX = str.length()-1;

        while (isPalindrome && MAX > MIN) {
            if (str.charAt(MIN) != str.charAt(MAX))
                isPalindrome = false;
            MIN++;
            MAX--;
        }
        return isPalindrome;
    }
}
