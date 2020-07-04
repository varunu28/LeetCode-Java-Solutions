class Solution {
  public int repeatedNTimes(int[] A) {
    int[] arr = new int[10001];
    for (int num : A) {
      if (arr[num] == 1) {
        return num;
      }
      arr[num]++;
    }
    return -1;
  }
}
