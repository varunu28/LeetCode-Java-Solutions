class Solution {
  public int countGoodRectangles(int[][] rectangles) {
    int maxSquareSide = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] rectangle : rectangles) {
      int currSquareSide = Math.min(rectangle[0], rectangle[1]);
      map.put(currSquareSide, map.getOrDefault(currSquareSide, 0) + 1);
      maxSquareSide = Math.max(maxSquareSide, currSquareSide);
    }
    return map.get(maxSquareSide);
  }
}
