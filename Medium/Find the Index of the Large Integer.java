/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
  public int getIndex(ArrayReader reader) {
    int left = 0;
    int right = reader.length() - 1;
    while (left < right) {
      int l = left;
      int r = (right + left - 1) / 2;
      int x = (right + left + 2) / 2;
      int y = right;
      int res = reader.compareSub(l, r, x, y);
      if (res == 0) {
        return (left + right) / 2;
      }
      else if (res == 1) {
        right = r;
      }
      else {
        left = x;
      }
    }
    return left;
  }
}
