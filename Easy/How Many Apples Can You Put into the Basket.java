class Solution {
  public int maxNumberOfApples(int[] arr) {
    int weight = 0;
    int currCount = 0;
    Arrays.sort(arr);
    for (int i = 0; i < arr.length && weight + arr[i] <= 5000; i++) {
      weight += arr[i];
      currCount++;
    }
    return currCount;
  }
}
