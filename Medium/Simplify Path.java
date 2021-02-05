class Solution {
  public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    String[] splits = path.split("/");
    for (String split : splits) {
      if (split.equals("") || split.equals(".")) {
        continue;
      } else if (split.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(split);
      }
    }
    StringBuilder resultingPath = new StringBuilder();
    while (!stack.isEmpty()) {
      resultingPath.insert(0, stack.pop()).insert(0, "/");
    }
    return resultingPath.length() == 0 ? "/" : resultingPath.toString();
  }
}
