class Solution {
  public int[][] flipAndInvertImage(int[][] A) {
    for (int[] arr : A) {
      reverse(arr);
      invert(arr);
    }
    return A;
  }
  
  private void reverse(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }
  
  private void invert(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr[i] ^ 1;
    }
  }
}
