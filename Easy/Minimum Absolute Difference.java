class Solution {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    List<List<Integer>> list = new ArrayList<>();
    int minDiff = Integer.MAX_VALUE;
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 1; i++) {
      int diff = arr[i + 1] - arr[i];
      if (diff < minDiff) {
        list.clear();
        list.add(Arrays.asList(arr[i], arr[i + 1]));
        minDiff = diff;
      }
      else if (diff == minDiff) {
        list.add(Arrays.asList(arr[i], arr[i + 1]));
      }
    }
    return list;
  }
}
