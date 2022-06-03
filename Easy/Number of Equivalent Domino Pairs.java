class Solution {
  public int numEquivDominoPairs(int[][] dominoes) {
    int numOfPairs = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] dominoe : dominoes) {
      int key = Math.min(dominoe[0], dominoe[1]) * 10 + Math.max(dominoe[0], dominoe[1]);
      numOfPairs += map.getOrDefault(key, 0);
      map.put(key, map.getOrDefault(key, 0) + 1);
    }
    return numOfPairs;
  }
}
