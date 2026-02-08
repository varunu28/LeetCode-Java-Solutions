class Solution {
    public boolean canBeValid(String s, String locked) {
        Stack<Integer> lockedIndex = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else {
                if (c == '(') {
                    lockedIndex.push(i);
                } else {
                    if (!lockedIndex.isEmpty()) {
                        lockedIndex.pop();
                    } else if (!unlocked.isEmpty()) {
                        unlocked.pop();
                    } else {
                        return false;
                    }
                }
            }
            
        }
        while (!lockedIndex.isEmpty()) {
            int removed = lockedIndex.pop();
            if (unlocked.isEmpty() || unlocked.peek() < removed) {
                return false;
            }
            unlocked.pop();
        }
        return unlocked.size() % 2 == 0;
    }
}
