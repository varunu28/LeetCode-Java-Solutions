class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Integer> openBrackets = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if (c == '(') {
                openBrackets.push(i);
            } else if (c == ')') {
                if (!openBrackets.isEmpty()) {
                    openBrackets.pop();
                } else if (!unlocked.isEmpty()) {
                    unlocked.pop();
                } else {
                    return false;
                }
            }
        }
        while (!openBrackets.isEmpty() && !unlocked.isEmpty() && openBrackets.peek() < unlocked.peek()) {
            openBrackets.pop();
            unlocked.pop();
        }
        return openBrackets.isEmpty();
    }
}
