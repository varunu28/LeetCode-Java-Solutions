class Solution {
  public int[] countSubTrees(int n, int[][] edges, String labels) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] edge : edges) {
      map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
      map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
    }
    int[] count = new int[n];
    Set<Integer> set = new HashSet<>();
    dfs(map, 0, labels, count, set);
    return count;
  }
  
  private int[] dfs(Map<Integer, List<Integer>> map, int curr, String labels, int[] count, Set<Integer> set) {
    int[] cnt = new int[26];
    if (set.add(curr)) {
      char c = labels.charAt(curr);
      for (Integer child : map.getOrDefault(curr, new ArrayList<>())) {
        int[] temp = dfs(map, child, labels, count, set);
        for (int i = 0; i < 26; i++) {
          cnt[i] += temp[i];
        }
      }
      cnt[c - 'a']++;
      count[curr] = cnt[c - 'a'];
    }
    return cnt;
  }
}

