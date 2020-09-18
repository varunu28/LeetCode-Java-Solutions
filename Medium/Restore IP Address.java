class Solution {
  public List<String> restoreIpAddresses(String s) {
    int n = s.length();
    LinkedList<String> segments = new LinkedList<String>();
    List<String> output = new ArrayList<String>();
    backtrack(s, -1, 3, output, segments, n);
    return output;
  }
  
  private void backtrack(String s, int prevPos, int dots, List<String> output, LinkedList<String> segments, int n) {
    int maxPos = Math.min(n - 1, prevPos + 4);
    for (int i = prevPos + 1; i < maxPos; i++) {
      String segment = s.substring(prevPos + 1, i + 1);
      if (isValid(segment)) {
        segments.add(segment);
        if (dots - 1 == 0) {
          updateOutput(s, i, n, segments, output);
        }
        else {
          backtrack(s, i, dots - 1, output, segments, n);
        }
        segments.removeLast();
      }
    }
  }
  
  public void updateOutput(String s, int currPos, int n, LinkedList<String> segments, List<String> output) {
    String segment = s.substring(currPos + 1, n);
    if (isValid(segment)) {
      segments.add(segment);
      output.add(String.join(".", segments));
      segments.removeLast();
    }
  }

  public boolean isValid(String segment) {
    int m = segment.length();
    if (m > 3)
      return false;
    return (segment.charAt(0) != '0') ? (Integer.parseInt(segment) <= 255) : (m == 1);
  }
}
