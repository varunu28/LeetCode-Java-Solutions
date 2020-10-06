class Solution {
  public int[] sortByBits(int[] arr) {
    return Arrays.stream(arr).boxed()
        .sorted(Comparator.comparingInt(Integer::bitCount).thenComparingInt(o -> o))
        .collect(Collectors.toList())
        .stream()
        .mapToInt(Integer::intValue)
        .toArray();
  }
}
