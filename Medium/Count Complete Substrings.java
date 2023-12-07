class Solution {
    public int countCompleteSubstrings(String word, int k) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            sb.append(word.charAt(i));
            if (i < n - 1 && Math.abs(word.charAt(i) - word.charAt(i + 1)) > 2) {
                count += calculateSubstrings(sb.toString(), k);
                sb.setLength(0);
            }
        }
        count += calculateSubstrings(sb.toString(), k);
        return count;
    }

    private int calculateSubstrings(String s, int k) {
        int count = 0;
        int n = s.length();
        for (int i = 1; i <= 26; i++) {
            int len = k * i;
            int[] freq = new int[26];
            if (len > n) {
                break;
            }
            for (int j = 0; j < len; j++) {
                freq[s.charAt(j) - 'a']++;
            }
            if (check(freq, i, k)) {
                count++;
            }
            for (int j = len; j < n; j++) {
                freq[s.charAt(j - len) - 'a']--;
                freq[s.charAt(j) - 'a']++;
                if (check(freq, i, k)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean check(int[] freq, int i, int k) {
        for (int value : freq) {
            if (value == 0) {
                continue;
            }
            if (value != k) {
                return false;
            }
        }
        return true;
    }
}
