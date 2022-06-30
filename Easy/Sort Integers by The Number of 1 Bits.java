class Solution {
  public int[] sortByBits(int[] arr) {
    return Arrays.stream(arr)
        .boxed()
        .sorted(Comparator.comparingInt(Integer::bitCount).thenComparingInt(o -> o))
        .mapToInt(Integer::intValue)
        .toArray();
  }
}
