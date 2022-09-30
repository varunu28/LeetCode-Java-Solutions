class Solution {
  public List<List<Integer>> getSkyline(int[][] buildings) {
    List<List<Integer>> result = new ArrayList<>();
    List<int[]> heights = new ArrayList<>();
    for (int[] building : buildings) {
      heights.add(new int[]{building[0], -1 * building[2]});
      heights.add(new int[]{building[1], 1 * building[2]});
    }
    Collections.sort(heights, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    pq.add(0);
    int previousMax = 0;
    for (int[] height : heights) {
      if (height[1] < 0) {
        pq.add(-1 * height[1]);
      } else {
        pq.remove(height[1]);
      }
      int currentMax = pq.peek();
      if (currentMax != previousMax) {
        result.add(Arrays.asList(height[0], currentMax));
        previousMax = currentMax;
      }
    }
    return result;
  }
}
