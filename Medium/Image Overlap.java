class Solution {
  public int largestOverlap(int[][] img1, int[][] img2) {
    List<Pair<Integer, Integer>> nonZeroCoordinates1 = getNonZeroCoordinates(img1);
    List<Pair<Integer, Integer>> nonZeroCoordinates2 = getNonZeroCoordinates(img2);
    int maxOverlap = 0;
    Map<Pair<Integer, Integer>, Integer> groupCount = new HashMap<>();
    for (Pair<Integer, Integer> c1 : nonZeroCoordinates1) {
      for (Pair<Integer, Integer> c2 : nonZeroCoordinates2) {
        Pair<Integer, Integer> vector = new Pair<Integer, Integer>(
          c2.getKey() - c1.getKey(), c2.getValue() - c1.getValue());
        groupCount.put(vector, groupCount.getOrDefault(vector, 0) + 1);
        maxOverlap = Math.max(maxOverlap, groupCount.get(vector));
      }
    }
    return maxOverlap;
  }
  
  private List<Pair<Integer, Integer>> getNonZeroCoordinates(int[][] arr) {
    List<Pair<Integer, Integer>> coordinates = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] == 1) {
          coordinates.add(new Pair(i, j));
        }
      }
    }
    return coordinates;
  }
}
