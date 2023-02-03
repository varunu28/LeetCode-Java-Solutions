class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int row = 0;
        int n = s.length();
        int idx = 0;
        while (idx < n) {
            while (idx < n && row < numRows) {
                rows[row++].append(s.charAt(idx++));
            }
            row -= 2;
            while (idx < n && row >= 0) {
                rows[row--].append(s.charAt(idx++));
            }
            row += 2;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rows) {
            result.append(sb.toString());
        }
        return result.toString();
    }
}
