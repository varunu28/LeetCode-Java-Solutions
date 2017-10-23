class Solution {
    public int findShortestSubArray(int[] nums) {
        
        int degree = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, ArrayList<Integer>> mapCheck = new HashMap<>();
        
        for (int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            }
            else {
                map.put(nums[i],1);
            }
            degree = Math.max(degree,map.get(nums[i]));
            
            if (mapCheck.containsKey(nums[i])) {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(mapCheck.get(nums[i]).get(0));
                arr.add(i);
                mapCheck.put(nums[i], arr);
            }
            else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                arr.add(i);
                mapCheck.put(nums[i], arr);
            }
        }
        
        int minSize = Integer.MAX_VALUE;
            
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == degree) {
                int start = mapCheck.get(entry.getKey()).get(0);
                int end = mapCheck.get(entry.getKey()).get(1);

                minSize = Math.min(end-start+1, minSize);
            }
        }
        
        return minSize;
    }
}
