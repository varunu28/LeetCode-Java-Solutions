class Solution {
  public int numJewelsInStones(String J, String S) {
    Set<Character> set = new HashSet<>();
    for (char c : J.toCharArray()) {
      set.add(c);
    }
    int count = 0;
    for (char c : S.toCharArray()) {
      if (set.contains(c)) {
        count++;
      }
    }
    return count;
  }
}
