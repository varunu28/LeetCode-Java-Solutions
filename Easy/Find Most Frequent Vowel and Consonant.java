class Solution {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxFreqSum(String s) {
        Map<Character, Integer> vowelFrequencies = new HashMap<>();
        Map<Character, Integer> consonantFrequencies = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (VOWELS.contains(c)) {
                vowelFrequencies.put(c, vowelFrequencies.getOrDefault(c, 0) + 1);
            } else {
                consonantFrequencies.put(c, consonantFrequencies.getOrDefault(c, 0) + 1);
            }
        }
        int maxVowelFrequency = 0;
        int maxConsonantFrequency = 0;
        for (Integer value : vowelFrequencies.values()) {
            maxVowelFrequency = Math.max(maxVowelFrequency, value);
        }
        for (Integer value : consonantFrequencies.values()) {
            maxConsonantFrequency = Math.max(maxConsonantFrequency, value);
        }
        return maxConsonantFrequency + maxVowelFrequency;
    }
}
