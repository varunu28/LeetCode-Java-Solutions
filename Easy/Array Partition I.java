class Solution {
  public int arrayPairSum(int[] nums) {
    int[] arr = new int[20001];
    for (int num : nums) {
      arr[num + 10000]++;
    }
    int sum = 0;
    boolean odd = true;
    for (int i = 0; i < arr.length; i++) {
      while (arr[i] > 0) {
        if (odd) {
          sum += i - 10000;
        }
        odd = !odd;
        arr[i]--;
      }
    }
    return sum;
  }
}
