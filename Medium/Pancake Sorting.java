class Solution {
  public List<Integer> pancakeSort(int[] arr) {
    List<Integer> result = new ArrayList<>();
    for (int i = arr.length; i > 0; i--) {
      int idx = findIdx(arr, i);
      if (idx != i - 1) {
        if (idx != 0) {
          result.add(idx + 1);
          flip(arr, idx + 1);
        }
        result.add(i);
        flip(arr, i);
      }
    }
    return result;
  }
  
  private void flip(int[] arr, int k) {
    for (int i = 0; i < k / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[k - i - 1];
      arr[k - i - 1] = temp;
    }
  }
  
  private int findIdx(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1;
  }
}
