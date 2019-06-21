class Solution {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSize = 0;
        int start = 0;
        int count = 0;
        
        for (int i = 0; i < tree.length; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            count++;
            
            while (map.size() > 2) {
                map.put(tree[start], map.getOrDefault(tree[start], 0) - 1);
                if (map.get(tree[start]) == 0) {
                    map.remove(tree[start]);
                }
                
                count--;
                start++;
            }
            
            maxSize = Math.max(maxSize, count);
        }
        
        return maxSize;
    }
}
