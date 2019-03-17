class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < time.length; i++) {
            if (map.containsKey((60 - time[i] % 60) % 60)) {
                count += map.get((60 - time[i] % 60) % 60);
            }
            
            map.put(time[i] % 60, map.getOrDefault(time[i] % 60, 0) + 1);
        }
        
        return count;
    }
}
