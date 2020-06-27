class Solution {
  public int totalFruit(int[] tree) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;
    int start = 0;
    int end = 0;
    int n = tree.length;
    while (end < n) {
      map.put(tree[end], map.getOrDefault(tree[end], 0) + 1);
      while (map.size() > 2) {
        map.put(tree[start], map.get(tree[start]) - 1);
        if (map.get(tree[start]) == 0) {
          map.remove(tree[start]);
        }
        start++;
      }
      end++;
      maxCount = Math.max(maxCount, end - start);
    }
    return maxCount;
  }
}
