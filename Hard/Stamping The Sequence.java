class Solution {
  public int[] movesToStamp(String stamp, String target) {
    char[] stampLetters = stamp.toCharArray();
    char[] targetLetters = target.toCharArray();
    List<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[target.length()];
    int count = 0;
    while (count < target.length()) {
      boolean replace = false;
      for (int i = 0; i <= target.length() - stamp.length(); i++) {
        if (!visited[i] && isReplacePossible(stampLetters, targetLetters, i)) {
          count = performStamping(targetLetters, i, stamp.length(), count);
          replace = true;
          visited[i] = true;
          result.add(i);
          if (count == targetLetters.length) {
            break;
          }
        }
      }
      if (!replace) {
        return new int[0];   
      }
    }
    int[] resArray = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      resArray[i] = result.get(result.size() - i - 1);
    }
    return resArray;
  }
  
  private boolean isReplacePossible(char[] stampLetters, char[] targetLetters, int idx) {
    for (int i = 0; i < stampLetters.length; i++) {
      if (targetLetters[i + idx] != '*' && targetLetters[i + idx] != stampLetters[i]) {
        return false;
      }
    }
    return true;
  }
    
  private int performStamping(char[] targetLetters, int idx, int stampLength, int count) {
    for (int i = 0; i < stampLength; i++) {
      if (targetLetters[i + idx] != '*') {
        targetLetters[i + idx] = '*';
        count++;
      }
    }
    return count;
  }
}
