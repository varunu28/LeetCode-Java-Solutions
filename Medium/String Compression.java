class Solution {
    public int compress(char[] chars) {
        int startIdx = 0;
        for (int i = 0; i < chars.length;) {
            char c = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == c) {
                count++;
                i++;
            }
            chars[startIdx++] = c;
            if (count > 1) {
                String temp = String.valueOf(count);
                for (char digit : temp.toCharArray()) {
                    chars[startIdx++] = digit;
                }
            }
        }
        return startIdx;
    }
}
