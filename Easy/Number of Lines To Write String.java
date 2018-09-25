class Solution {
    public static int[] numberOfLines(int[] widths, String S) {
        if (S.isEmpty()) {
            return new int[]{0,0};
        }

        int capacity = 100;
        char[] chars = S.toCharArray();
        int count = 1;

        for (char c : chars) {
            if (capacity - widths[c-'a'] < 0) {
                capacity = 100;
                count++;
            }
            capacity -= widths[c-'a'];
        }

        return new int[]{count, 100-capacity};
    }
}
