class Solution {
  public String firstPalindrome(String[] words) {
    return Arrays.stream(words).filter(Solution::isPalindrome).findFirst().orElse("");
  }
  
  public static boolean isPalindrome(String s) {
    return new StringBuilder().append(s).reverse().toString().equals(s);
  }
}
