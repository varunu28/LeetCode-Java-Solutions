class Solution {
  public int getWinner(int[] arr, int k) {
    int currentElement = arr[0];
    int n = arr.length;
    int currentWinCount = 0;
    for (int i = 1; i < n; i++) {
      if (arr[i] > currentElement) {
        currentElement = arr[i];
        currentWinCount = 0;
      }
      if (++currentWinCount == k) {
        break;
      }
    }
    return currentElement;
  }
}
