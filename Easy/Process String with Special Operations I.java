class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '*' -> {
                    if (!sb.isEmpty()) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
                case '#' -> {
                    if (!sb.isEmpty()) {
                        sb.append(sb);
                    }
                }
                case '%' -> sb.reverse();
                default -> sb.append(c);
            }
        }
        return sb.toString();
    }
}
