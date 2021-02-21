class Solution {
  public String longestNiceSubstring(String s) {
    Set<Character> set = s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!(set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c)))) {
        String left = longestNiceSubstring(s.substring(0, i));
        String right = longestNiceSubstring(s.substring(i + 1));
        return left.length() >= right.length() ? left : right; 
      }
    }
    return s;
  }
}
