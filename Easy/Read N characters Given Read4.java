/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */

public class Solution extends Reader4 {
  /**
   * @param buf Destination buffer
   * @param n   Number of characters to read
   * @return    The number of actual characters read
   */
  public int read(char[] buf, int n) {
    boolean endOfFile = false;
    int totalLength = 0;
    char[] temp = new char[4];
    while (!endOfFile && totalLength < n) {
      int count = read4(temp);
      endOfFile = count < 4;
      count = Math.min(count, n - totalLength);
      for (int i = 0; i < count; i++) {
        buf[totalLength++] = temp[i];
      }
    }
    return totalLength;
  }
}
