class Solution {
    public int numSteps(String s) {
        int operations = 0;
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 1) {
            int n = sb.length();
            if (sb.charAt(n - 1) == '0') {
                // divide by 2
                sb.deleteCharAt(n - 1);
            } else {
                // add 1 
                int idx = n - 1;
                while (idx >= 0 && sb.charAt(idx) != '0') {
                    sb.setCharAt(idx, '0');
                    idx--;
                }
                if (idx < 0) {
                    sb.insert(0, '1');
                } else {
                    sb.setCharAt(idx, '1');
                }
            }
            operations++;
        }
        return operations;
    }
}
