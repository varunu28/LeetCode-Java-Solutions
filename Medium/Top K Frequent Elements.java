class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            }
            else {
                map.put(nums[i], 1);
            }
        }
        
        Map<Integer, Integer> sortedMap = sortByValue(map);
        
        List<Integer> ans = new ArrayList<>();
        int c = 0;
        
        for (Map.Entry<Integer,Integer> entry : sortedMap.entrySet()) {
            if (c == k) break;
            ans.add(entry.getKey());
            
            c++;
        }
        
        return ans;
    }
    
    private Map<Integer, Integer> sortByValue(Map<Integer, Integer> unsortMap) {

        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
