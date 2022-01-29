class Solution {
  public int[] findBuildings(int[] heights) {
    List<Integer> oceanViewBuildings = new ArrayList<>();
    int maxHeight = 0;
    for (int i = heights.length - 1; i >= 0; i--) {
      if (heights[i] > maxHeight) {
        oceanViewBuildings.add(i);
      }
      maxHeight = Math.max(maxHeight, heights[i]);
    }
    return oceanViewBuildings.stream().sorted().mapToInt(Integer::valueOf).toArray();
  }
}
