class Solution {
  public List<String> commonChars(String[] A) {
    int[][] counter = new int[A.length][26];
    for (int i = 0; i < A.length; i++) {
      for (char c : A[i].toCharArray()) {
        counter[i][c - 'a']++;
      }
    }
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      int minCount = Integer.MAX_VALUE;
      for (int j = 0; j < counter.length; j++) {
        minCount = Math.min(minCount, counter[j][i]);
      }
      while (minCount-- > 0) {
        list.add(String.valueOf((char) (97 + i)));
      }
    }
    return list;
  }
}
