class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int n = groupSizes.length;
        for (int i = 0; i < n; i++) {
            int size = groupSizes[i];
            if (!map.containsKey(size)) {
                map.put(size, new ArrayList<>());
                map.get(size).add(new ArrayList<>());
            }
            int arraySize = map.get(size).size();
            if (map.get(size).get(arraySize - 1).size() == size) {
                map.get(size).add(new ArrayList<>());
                arraySize++;
            }
            map.get(size).get(arraySize - 1).add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Integer key : map.keySet()) {
            List<List<Integer>> lists = map.get(key);
            for (List<Integer> list : lists) {
                ans.add(list);
            }
        }
        return ans;
    }
}
