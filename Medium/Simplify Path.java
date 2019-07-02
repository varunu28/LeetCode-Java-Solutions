class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int n = path.length();

        while (idx < n) {
            if (path.charAt(idx) != '/') {
                sb.append(path.charAt(idx));
                while (idx + 1 < n && path.charAt(idx + 1) != '/') {
                    sb.append(path.charAt(idx + 1));
                    idx++;
                }

                if (sb.toString().equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
                else if (!sb.toString().equals(".")) {
                    stack.push(sb.toString());
                }

                sb.setLength(0);
            }

            idx++;
        }

        List<String> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        sb.append("/");
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
            if (i != 0) {
                sb.append("/");
            }
        }

        return sb.toString();
    }
}
