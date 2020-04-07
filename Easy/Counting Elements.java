class Solution {
  public int countElements(int[] arr) {
    int[] counter = new int[1001];
    for (int num : arr) {
      counter[num]++;
    }
    int count = 0;
    for (int i = 0; i < 1001; i++) {
      if (i != 1000 && counter[i + 1] != 0) {
        count += counter[i];
      }
    }
    return count;
  }
}
