class Solution {
  public long countVowels(String word) {
    long sum = 0;
    long n = word.length();
    for (int i = 0; i < n; i++) {
      if ("aeiou".indexOf(word.charAt(i)) != -1) {
        sum += (i + 1) * (n - i);
      }
    }
    return sum;
  }
}
