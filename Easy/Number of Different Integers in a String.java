class Solution {
  public int numDifferentIntegers(String word) {
    Set<Integer> set = new HashSet<>();
    int idx = 0;
    int n = word.length(); 
    while (idx < n) {
      if (Character.isDigit(word.charAt(idx))) {
        int num = 0;
        while (idx < n && Character.isDigit(word.charAt(idx))) {
          num = num * 10 + Character.getNumericValue(word.charAt(idx++));
        }
        set.add(num);
      } 
      idx++;
    }
    return set.size();
  }
}
