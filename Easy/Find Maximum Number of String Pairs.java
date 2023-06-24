class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> set = new HashSet<>();
        int pairCount = 0;
        for (String word : words) {
            if (set.contains(new StringBuilder(word).reverse().toString())) {
                pairCount++;
            }
            set.add(word);
        }
        return pairCount;
    }
}
