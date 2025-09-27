class Solution {
    public String majorityFrequencyGroup(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        Map<Integer, Set<Character>> frequencyToCharMap = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            frequencyToCharMap
            .computeIfAbsent(entry.getValue(), k -> new HashSet<>())
            .add(entry.getKey());
        }
        int maxGroupSize = 0;
        int frequencyForMaxGroup = 0;
        for (Map.Entry<Integer, Set<Character>> entry : frequencyToCharMap.entrySet()) {
            int currentGroupSize = entry.getValue().size();
            int currentFrequency = entry.getKey();
            if (currentGroupSize == maxGroupSize) {
                if (frequencyForMaxGroup < currentFrequency) {
                    frequencyForMaxGroup = currentFrequency;
                }
            } else if (currentGroupSize > maxGroupSize) {
                maxGroupSize = currentGroupSize;
                frequencyForMaxGroup = currentFrequency;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : frequencyToCharMap.get(frequencyForMaxGroup)) {
            sb.append(c);
        }
        return sb.toString();
    }
}
