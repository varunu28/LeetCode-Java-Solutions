class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = createMap(list1);
        Map<String, Integer> map2 = createMap(list2);
        int minIndexSum = Integer.MAX_VALUE;
        int count = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                int idxSum = map1.get(key) + map2.get(key);
                if (idxSum < minIndexSum) {
                    minIndexSum = idxSum;
                    count = 1;
                }
                else if (idxSum == minIndexSum){
                    count++;
                }
            }
        }
        String[] ans = new String[count];
        int idx = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                if (map1.get(key) + map2.get(key) == minIndexSum) {
                    ans[idx++] = key;
                }
            }
        }
        return ans;
    }

    private Map<String, Integer> createMap(String[] list) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            map.put(list[i], i);
        }
        return map;
    }
}
