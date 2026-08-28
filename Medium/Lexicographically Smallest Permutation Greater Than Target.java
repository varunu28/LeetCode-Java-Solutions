class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int n = target.length();
        for (int i = 0; i < n; i++) {
            int targetChar = target.charAt(i) - 'a';
            if (counter[targetChar] > 0) {
                counter[targetChar]--;
                if (canForm(counter, target, i + 1)) {
                    sb.append(target.charAt(i));
                    continue;
                }
                counter[targetChar]++;
            }
            for (int j = targetChar + 1; j < 26; j++) {
                if (counter[j] > 0) {
                    counter[j]--;
                    sb.append((char) ('a' + j));
                    sb.append(getMinString(counter));
                    return sb.toString();
                }
            }
            return "";
        }
        return "";
    }

    private boolean canForm(int[] counter, String target, int start) {
        String maxString = getMaxString(counter);
        String suffix = target.substring(start);
        return maxString.compareTo(suffix) > 0;
    }

    private String getMaxString(int[] counter) {
        StringBuilder result = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            if (counter[i] > 0) {
                result.append(String.valueOf((char) ('a' + i)).repeat(counter[i]));
            }
        }
        return result.toString();
    }

    private String getMinString(int[] counter) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (counter[i] > 0) {
                result.append(String.valueOf((char) ('a' + i)).repeat(counter[i]));
            }
        }
        return result.toString();
    }
}
