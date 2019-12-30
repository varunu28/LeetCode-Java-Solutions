class Solution {
  public int[] replaceElements(int[] arr) {
    int maxVal = -1;
    for (int i = arr.length - 1; i >= 0; i--) {
      int temp = arr[i];
      arr[i] = maxVal;
      maxVal = Math.max(maxVal, temp);
    }
    return arr;
  }
}
