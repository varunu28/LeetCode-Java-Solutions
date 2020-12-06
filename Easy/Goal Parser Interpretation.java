class Solution {
  public String interpret(String command) {
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    while (idx < command.length()) {
      if (command.charAt(idx) == '(') {
        if (command.charAt(idx + 1) == ')') {
          sb.append('o');
          idx++;
        } else {
          idx++;
          while (command.charAt(idx) != ')') {
            sb.append(command.charAt(idx++));
          }
        }
        idx++;
      } else {
        sb.append(command.charAt(idx++));
      }
    }
    return sb.toString();
  }
}
