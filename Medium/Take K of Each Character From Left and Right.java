class Solution {
    public int takeCharacters(String s, int k) {
        int[] counter = new int[3];
        int n = s.length();
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        for (int i = 0; i < 3; i++) {
            if (counter[i] < k) {
                return -1;
            }
        }
        int[] window = new int[3];
        int left = 0;
        int maxWindow = 0;
        for (int right = 0; right < n; right++) {
            window[s.charAt(right) - 'a']++;
            while (left <= right && 
                (counter[0] - window[0] < k || counter[1] - window[1] < k || counter[2] - window[2] < k)) {
                window[s.charAt(left) - 'a']--;
                left++;
            }
            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        return n - maxWindow;
    }
}
