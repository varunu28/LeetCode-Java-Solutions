class Solution {
  public int[] gardenNoAdj(int N, int[][] paths) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] path : paths) {
      map.computeIfAbsent(path[0], k -> new ArrayList<>()).add(path[1]);
      map.computeIfAbsent(path[1], k -> new ArrayList<>()).add(path[0]);
    }
    int[] ans = new int[N];
    for (int i = 0; i < N; i++) {
      Set<Integer> neighbourPlant = new HashSet<>();
      for (Integer neighbour : map.getOrDefault(i + 1, new ArrayList<>())) {
        if (ans[neighbour - 1] != 0) {
          neighbourPlant.add(ans[neighbour - 1]);
        }
      }
      for (int j = 1; j <= 4; j++) {
        if (!neighbourPlant.contains(j)) {
          ans[i] = j;
          break;
        }
      }
    }
    return ans;
  }
}
