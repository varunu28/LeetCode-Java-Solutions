class Solution {
  public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
    int[][] count = new int[s.length() + 1][26];
    for (int i = 0; i < s.length(); i++) {
      count[i + 1] = count[i].clone();
      count[i + 1][s.charAt(i) - 'a']++;
    }
    List<Boolean> list = new ArrayList<>();
    for (int[] query : queries) {
      int sum = 0;
      for (int i = 0; i < 26; i++) {
        sum += (count[query[1] + 1][i] - count[query[0]][i]) % 2;
      }
      list.add(sum / 2 <= query[2]);
    }
    return list;
  }
}
