class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
     return Arrays.stream(arr)
        .mapToObj(e -> new int[]{e, Math.abs(e - x)})
        .sorted((o1, o2) -> (o1[1] - o2[1] != 0) ? (o1[1] - o2[1]) : o1[0] - o2[0])
        .map(e -> e[0])
        .limit(k)
        .sorted()
        .collect(Collectors.toList());
  }
}
