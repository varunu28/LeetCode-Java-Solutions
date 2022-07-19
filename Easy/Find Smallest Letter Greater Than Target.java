class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
    int start = 0;
    int end = letters.length - 1;
    int minIdx = Integer.MAX_VALUE;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (letters[mid] > target) {
        minIdx = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return minIdx == Integer.MAX_VALUE ? letters[0] : letters[minIdx];
  }
}
