class Solution {
  private static final String VOWELS = "aeiouAEIOU";
  public boolean halvesAreAlike(String s) {
    return getVowelCount(s.substring(0, s.length() / 2)).equals(getVowelCount(s.substring(s.length() / 2)));
  }
  
  private Long getVowelCount(String s) {
    return s.chars().mapToObj(c -> (char) c).filter(Solution::isVowel).count();
  }
  
  private static boolean isVowel(char c) {
    return VOWELS.indexOf(c) != -1;
  }
}
