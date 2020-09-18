class Solution {
  public int hIndex(int[] citations) {
    int n = citations.length;
    Arrays.sort(citations);
    for (int i = n - 1; i >= 0; i--) {
      if (n - i > citations[i]) {
        return n - i - 1;
      }
    }
    return n;
  }
}
