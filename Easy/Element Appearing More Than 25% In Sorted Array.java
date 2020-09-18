class Solution {
  public int findSpecialInteger(int[] arr) {
    int n = arr.length;
    int oneFourthNum = arr[n / 4];
    int halfNum = arr[n / 2];
    int threeFourthNum = arr[3 * n / 4];
    if(Math.max(n/4, binarySearchRight(arr, 0, n - 1, oneFourthNum)) - 
       Math.min(n/4, binarySearchLeft(arr, 0, n - 1, oneFourthNum)) >= arr.length / 4) {
         return oneFourthNum;
       }
    if(Math.max(n/2, binarySearchRight(arr, 0, n - 1, halfNum)) - 
       Math.min(n/2, binarySearchLeft(arr, 0, n - 1, halfNum)) >= arr.length / 4) {
         return halfNum;
       }
    if(Math.max((3 * n)/4, binarySearchRight(arr, 0, n - 1, threeFourthNum)) - 
       Math.min((3 * n)/4, binarySearchLeft(arr, 0, n - 1, threeFourthNum)) >= arr.length / 4) {
         return threeFourthNum;
       }
    return -1;
  }
  
  private int binarySearchLeft(int[] arr, int start, int end, int num) {
    int minIdx = Integer.MAX_VALUE;
    while (start < end) {
      int mid = (start + end) / 2;
      if (arr[mid] == num) {
        minIdx = Math.min(mid, minIdx);
        end = mid - 1;
      }
      else if (arr[mid] < num) {
        start = mid + 1;
      }
      else {
        end = mid - 1;
      }
    }
    return minIdx;
  }
  
  private int binarySearchRight(int[] arr, int start, int end, int num) {
    int maxIdx = Integer.MIN_VALUE;
    while (start < end) {
      int mid = (start + end) / 2;
      if (arr[mid] == num) {
        maxIdx = Math.max(mid, maxIdx);
        start = mid + 1;
      }
      else if (arr[mid] < num) {
        start = mid + 1;
      }
      else {
        end = mid - 1;
      }
    }
    return maxIdx;
  }
}
