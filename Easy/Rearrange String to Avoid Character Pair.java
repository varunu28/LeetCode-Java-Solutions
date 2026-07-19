class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder sb = new StringBuilder();
        int xCount = 0;
        for (char c : s.toCharArray()) {
            if (c == x) {
                xCount++;
            } else {
                sb.append(c);
            }
        }
        return sb.append(String.valueOf(x).repeat(xCount)).toString();
    }
}
