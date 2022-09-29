class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    List<Integer> result = new ArrayList<>();
    if (arr.length == k) {
      for (int num : arr) {
        result.add(num);
      }
      return result;
    }
    int left = 0;
    int right = arr.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (arr[mid] >= x) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    left--;
    right = left + 1;
    while (right - left - 1 < k) {
      if (left == -1) {
        right++;
        continue;
      }
      if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
        left--;
      } else {
        right++;
      }
    }
    for (int i = left + 1; i < right; i++) {
      result.add(arr[i]);
    }
    return result;
  }
}
