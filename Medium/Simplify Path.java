class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] splits = path.split("\\/");
        for (String split : splits) {
            if (split.equals(".") || split.equals("/") || split.isBlank()) {
                continue;
            }
            if (split.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(split);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop()).insert(0, "/");
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
