class Solution {
  public int maximum69Number (int num) {
    char[] chars = String.valueOf(num).toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '6') {
        chars[i] = '9';
        break;
      }
    }
    return Integer.parseInt(String.valueOf(chars));
  }
}
