class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            
            bucket[frequency].add(key);
        }
        
        List<Integer> res = new ArrayList<>();
        
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        
        return res;
    }
}
