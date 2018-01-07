class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        for (int i=0;i<nums1.length;i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }
        
        for (int i=0;i<nums2.length;i++) {
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                int count = Math.min(entry.getValue(), map2.get(entry.getKey()));
                while (count > 0) {
                    list.add(entry.getKey());
                    count--;
                }
            }
        }
        
        int[] ans = new int[list.size()];
        
        for (int i=0;i<list.size();i++) {
            ans[i] = list.get(i);
        } 
        
        return ans;
    }
}
