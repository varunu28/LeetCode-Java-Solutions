class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Integer> frequencyCountMap = new HashMap<>();
        for (int num : nums) {
            int previousFrequency = frequencyMap.getOrDefault(num, 0);
            int newFrequency = previousFrequency + 1;
            if (previousFrequency > 0) {
                frequencyCountMap.put(previousFrequency, frequencyCountMap.get(previousFrequency) - 1);
            }
            frequencyMap.put(num, newFrequency);
            frequencyCountMap.put(newFrequency, frequencyCountMap.getOrDefault(newFrequency, 0) + 1);
        }
        for (int num : nums) {
            int frequency = frequencyMap.get(num);
            if (frequencyCountMap.get(frequency) == 1) {
                return num;
            }
        }
        return -1;
    }
}
