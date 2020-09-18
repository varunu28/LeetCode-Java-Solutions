class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
    int start = 0;
    int end = letters.length - 1;
    // ASCII char greater than 'z'
    char smallestChar = '{';
    while (start <= end) {
      int mid = (start + end) / 2;
      if (letters[mid] - target > 0) {
        if (smallestChar - letters[mid] > 0) {
          smallestChar = letters[mid];
        }
        end = mid - 1;
      }
      else if (letters[mid] - target == 0) {
        start = mid + 1;
      }
      else {
        start = mid + 1;
      }
    }
    return smallestChar == '{' ? letters[0] : smallestChar;
  }
}
