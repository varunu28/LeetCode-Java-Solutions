class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String target = words[i];
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].startsWith(target) && words[j].endsWith(target)) {
                    count++;
                }
            }
        }
        return count;
    }
}
