class Solution {
    public int minSwaps(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> openBrackets = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[') {
                openBrackets.push(i);
            }
        }
        int open = 0;
        int swaps = 0;
        for (int i = 0; i < chars.length; i++) {
            open += chars[i] == '[' ? 1 : -1;
            if (open < 0) {
                swaps++;
                int endIdx = openBrackets.pop();
                chars[endIdx] = ']';
                chars[i] = '[';
                open += 2;
            }
        }
        return swaps;
    }
}
