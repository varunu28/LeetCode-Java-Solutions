class Solution {
  public int[][] flipAndInvertImage(int[][] A) {
    for (int[] arr : A) {
      int start = 0;
      int end = arr.length - 1;
      while (start < end) {
        int temp = arr[start];
        arr[start++] = arr[end];
        arr[end--] = temp;
      }
    }
    for (int[] arr : A) {
      for (int i = 0; i < arr.length; i++) {
        arr[i] = arr[i] == 1 ? 0 : 1;
      }
    }
    return A;
  }
}
