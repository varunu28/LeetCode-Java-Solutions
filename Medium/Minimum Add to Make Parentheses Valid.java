class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            open += c == '(' ? 1 : -1;
            if (open < 0) {
                count += Math.abs(open);
                open = 0;
            }
        }
        return count + open;
    }
}
