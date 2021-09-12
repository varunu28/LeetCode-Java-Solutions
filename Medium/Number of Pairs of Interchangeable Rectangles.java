class Solution {
  public long interchangeableRectangles(int[][] rectangles) {
    return Arrays.stream(rectangles)
        .collect(Collectors.groupingBy(
            e -> ((double) e[0]) / e[1], HashMap::new, Collectors.counting()))
        .values()
        .stream()
        .map(v -> (v * (v - 1)) / 2)
        .reduce(0L, Long::sum);
  }
}
