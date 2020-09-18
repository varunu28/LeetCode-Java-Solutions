class Solution {
  public int findLucky(int[] arr) {
    int[] counter = new int[501];
    for (int num : arr) {
      counter[num]++;
    }
    for (int i = 500; i > 0; i--) {
      if (counter[i] == i) {
        return i;
      }
    }
    return -1;
  }
}
