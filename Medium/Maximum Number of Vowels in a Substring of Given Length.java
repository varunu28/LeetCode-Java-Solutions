class Solution {
  public int maxVowels(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    String vowels = "aeiou";
    int count = 0;
    int maxCount = 0;
    int start = 0;
    int end = 0;
    int n = s.length();
    while (end < (k - 1)) {
      if (vowels.indexOf(s.charAt(end)) != -1) {
        map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
        count++;
      }
      end++;
    }
    while (end < n) {
       if (vowels.indexOf(s.charAt(end)) != -1) {
        map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
         count++;
      }
      end++;
      maxCount = Math.max(maxCount, count);
      if (vowels.indexOf(s.charAt(start)) != -1) {
        map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) - 1);
        count--;
      }
      start++;
    }
    return maxCount;
  }
}
