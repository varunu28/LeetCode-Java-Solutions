class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }
        while (k-- > 0) {
            String temp = sb.toString();
            sb.setLength(0);
            int val = 0;
            for (char c : temp.toCharArray()) {
                val += Character.getNumericValue(c);
            }
            sb.append(val);
        }
        return Integer.parseInt(sb.toString());
    }
}
