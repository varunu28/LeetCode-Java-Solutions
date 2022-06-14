class Solution {
  public int[] gardenNoAdj(int n, int[][] paths) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] path : paths) {
      map.computeIfAbsent(path[0], k -> new HashSet<>()).add(path[1]);
      map.computeIfAbsent(path[1], k -> new HashSet<>()).add(path[0]);
    }
    int[] result = new int[n];
    for (int i = 1; i <= n; i++) {
      int[] colors = new int[5];
      for (int neighbor : map.getOrDefault(i, new HashSet<>())) {
        colors[result[neighbor - 1]] = 1;
      }      
      for (int c = 4; c > 0; c--) {
        if (colors[c] != 1) {
          result[i - 1] = c;
        }
      }
    }
    return result;
  }
}
