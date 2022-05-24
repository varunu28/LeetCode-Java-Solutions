class Solution {
  public boolean isStrobogrammatic(String num) {
    StringBuilder sb = new StringBuilder();
    for (char c : num.toCharArray()) {
      if (c == '6' || c == '9') {
        sb.append(c == '6' ? '9' : '6');
      } else if (c == '0' || c == '8' || c == '1') {
        sb.append(c);
      } else {
        return false;
      }
    }
    return sb.reverse().toString().equals(num);
  }
}
