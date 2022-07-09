class Solution {
  public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    Arrays.sort(arr2);
    int distance = 0;
    for (int i = 0; i < arr1.length; i++) {
      if (outsideRange(arr2, arr1[i] - d, arr1[i] + d)) {
        distance++;
      }
    }
    return distance;
  }
  
  private static boolean outsideRange(int[] arr, int from, int to) {
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] >= from && arr[mid] <= to) {
        return false;
      } else if (arr[mid] < from) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return true;
  }
}
