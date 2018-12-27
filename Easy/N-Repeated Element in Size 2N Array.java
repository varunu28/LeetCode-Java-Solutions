class Solution {
    public int repeatedNTimes(int[] A) {
        int maxCounter = A.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            
            if (map.get(num) == maxCounter) {
                return num;
            }
        }
        
        return -1;
    }
}
