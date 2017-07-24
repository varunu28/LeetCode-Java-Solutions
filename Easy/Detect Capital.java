public class Solution {
    public boolean detectCapitalUse(String word) {
        boolean capitalFirst = Character.isUpperCase(word.charAt(0));
        if (word.length() > 1) {
            boolean capitalSec = Character.isUpperCase(word.charAt(1));
            for (int i=1;i<word.length();i++) {
                if (capitalFirst && capitalSec) {
                    if (Character.isUpperCase(word.charAt(i)) == false) {
                        return false;
                    }
                }
                else if (capitalFirst && capitalSec == false) {
                    if (Character.isUpperCase(word.charAt(i)) == true) {
                        return false;
                    }
                }
                else {
                    if (Character.isUpperCase(word.charAt(i)) == true) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}