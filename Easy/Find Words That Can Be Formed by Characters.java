class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Long> targetMap = buildFrequencyMap(chars);
        return Arrays.stream(words)
                .filter(word -> doesIntersect(buildFrequencyMap(word), targetMap))
                .mapToInt(String::length)
                .sum();
    }

    private static boolean doesIntersect(Map<Character, Long> currMap, Map<Character, Long> targetMap) {
        for (Character key : currMap.keySet()) {
            if (targetMap.getOrDefault(key, 0L) < currMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Long> buildFrequencyMap(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
    }
}
