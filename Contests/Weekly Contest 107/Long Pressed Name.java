class Solution {
    public static boolean isLongPressedName(String name, String typed) {
        int slow = 0;
        int fast = 0;

        while (slow < name.length() && fast < typed.length()) {
            if (name.charAt(slow) == typed.charAt(fast)) {
                slow++;
                fast++;
            }
            else if (fast > 0 && typed.charAt(fast) == typed.charAt(fast-1)) {
                fast++;
            }
            else {
                return false;
            }
        }

        while (fast < typed.length()) {
            if (typed.charAt(fast) != typed.charAt(fast-1)) {
                return false;
            }

            fast++;
        }

        return slow == name.length();
    }
}
