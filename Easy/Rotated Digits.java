class Solution {
  public int rotatedDigits(int N) {
    int count = 0;
    for (int i = 1; i <= N; i++) {
      if (isGood(String.valueOf(i))) {
        count++;
      }
    }
    return count;
  } 
  
  private boolean isGood(String num) {
    StringBuilder sb = new StringBuilder();
    for (char c : num.toCharArray()) {
      if (c == '0' || c == '1' || c == '8') {
        sb.append(c);
      }
      else if (c == '2' || c == '5') {
        sb.append(c == '2' ? '5' : '2');
      }
      else if (c == '6' || c == '9') {
        sb.append(c == '6' ? '9' : '6');
      }
      else {
        return false;
      }
    }
    return !sb.toString().equals(num);
  }
}
