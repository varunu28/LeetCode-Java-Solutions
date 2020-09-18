class Solution {
  public List<Integer> transformArray(int[] arr) {
    int[] ans = new int[arr.length];
    while (!Arrays.equals(ans, arr)) {
      ans = arr.clone();
      for (int i = 1; i < arr.length - 1; i++) {
        if (ans[i] > ans[i - 1] && ans[i] > ans[i + 1]) {
          arr[i]--;
        }
        else if (ans[i - 1] > ans[i] && ans[i + 1] > ans[i]) {
          arr[i]++;
        }
      }
    }
    return Arrays.stream(ans).boxed().collect(Collectors.toList());
  }
}
