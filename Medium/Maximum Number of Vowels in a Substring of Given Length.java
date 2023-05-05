class Solution {
    public int maxVowels(String s, int k) {
        int currCount = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for (int i = 0; i < k - 1; i++) {
            if (vowels.contains(s.charAt(i))) {
                currCount++;
            }
        }
        int maxCount = 0;
        int start = 0;
        for (int i = k - 1; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                currCount++;
            }
            maxCount = Math.max(maxCount, currCount);
            if (vowels.contains(s.charAt(start++))) {
                currCount--;
            }
        }
        return maxCount;
    }
}
