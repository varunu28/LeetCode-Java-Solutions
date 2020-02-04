class Solution {
  public int numEquivDominoPairs(int[][] dominoes) {
    int count = 0;
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < dominoes.length; i++) {
      String straightKey = dominoes[i][0] + "/" + dominoes[i][1];
      String revKey = dominoes[i][1] + "/" + dominoes[i][0];
      if (map.containsKey(straightKey)) {
        count += map.get(straightKey);
      }
      else if (!straightKey.equals(revKey)) {
        if (map.containsKey(revKey)) {
          count += map.get(revKey);
        }
      }
      map.put(straightKey, map.getOrDefault(straightKey, 0) + 1);
      if (dominoes[i][0] != dominoes[i][1]) {
        map.put(revKey, map.getOrDefault(revKey, 0) + 1);
      }
    }
    return count;
  }
}
