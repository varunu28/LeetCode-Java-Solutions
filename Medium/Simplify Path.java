class Solution {
    public String simplifyPath(String path) {
        String[] splitPaths = path.split("\\/");
        Stack<String> paths = new Stack<>();
        for (String p : splitPaths) {
            if (p.length() == 0 || p.equals("/") || p.equals(" ") || p.equals(".")) {
                continue;
            }

            if (p.equals("..")) {
                if (!paths.isEmpty()) {
                    paths.pop();
                }
            }
            else {
                paths.push(p.trim());
            }
        }

        Stack<String> revPath = new Stack<>();
        while (!paths.isEmpty()) {
            revPath.push(paths.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!revPath.isEmpty()) {
            sb.append("/").append(revPath.pop());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
