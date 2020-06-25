package learn.java.codeaccess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {
    @Test
    public void isPalindrome() {
        String str = "abut-1-tuba";
        assertTrue(Palindrome.isPalindrome(str));

        String str2 = "@allula";
        assertFalse(Palindrome.isPalindrome(str2));
    }
}