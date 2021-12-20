class Solution {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    int minDiff = Integer.MAX_VALUE;
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 1; i++) {
      minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
    }
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i + 1] - arr[i] == minDiff) {
        result.add(Arrays.asList(arr[i], arr[i + 1]));        
      }
    }
    return result;
  }
}
