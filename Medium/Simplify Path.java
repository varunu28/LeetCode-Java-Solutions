class Solution {
  public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    int n = path.length();
    while (idx < n) {
      if (path.charAt(idx) == '/') {
        idx++;
        while (idx < n && path.charAt(idx) != '/') {
          sb.append(path.charAt(idx++));
        }
        String dir = sb.toString();
        sb.setLength(0);
        if (dir.equals("..")) {
          if (!stack.isEmpty()) {
            stack.pop(); 
          }
        }
        else if (dir.equals(".") || dir.length() == 0) {
          continue;
        }
        else {
          stack.push(dir);
        }
      }
    }
    sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.insert(0, stack.pop());
      sb.insert(0, "/");
    }
    return sb.length() > 0 ? sb.toString() : "/";
  }
}
