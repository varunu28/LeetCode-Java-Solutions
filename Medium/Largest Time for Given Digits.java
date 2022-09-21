class Solution {
  public String largestTimeFromDigits(int[] arr) {
    int[] maxTime = {-1};
    permute(arr, 0, maxTime);
    return maxTime[0] == -1 ? "" : String.format("%02d:%02d", maxTime[0] / 60, maxTime[0] % 60);
  }
  
  private void permute(int[] arr, int idx, int[] maxTime) {
    if (idx == arr.length) {
      buildTime(arr, maxTime);
      return;
    }
    for (int i = idx; i < arr.length; i++) {
      swap(arr, i, idx);
      permute(arr, idx + 1, maxTime);
      swap(arr, idx, i);
    }
  }
  
  private void buildTime(int[] arr, int[] maxTime) {
    int hour = arr[0] * 10 + arr[1];
    int minutes = arr[2] * 10 + arr[3];
    if (hour < 24 && minutes < 60) {
      maxTime[0] = Math.max(maxTime[0], hour * 60 + minutes);
    }
  }
  
  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
