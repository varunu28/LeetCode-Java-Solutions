class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }
        
        int count = 0;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            
            int valid = entry.getKey() + 1;
            
            if (entry.getValue() <= valid) {
                count += valid;
                map.put(entry.getKey(), 0);
            }
            else {
                int changed = entry.getValue()%valid;
                count += (entry.getValue()/valid)*valid;

                map.put(entry.getKey(), changed);
            }
            
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                count += entry.getKey() + 1;
            }
        }
        
        return count;
    }
}
