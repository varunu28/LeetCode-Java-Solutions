class Solution {
    public int totalFruit(int[] fruits) {
        int maximumFruits = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        while (end < fruits.length) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);
            end++;
            while (start < end && map.size() > 2) {
                map.put(fruits[start], map.get(fruits[start]) - 1);
                if (map.get(fruits[start]) == 0) {
                    map.remove(fruits[start]);
                }
                start++;
            }
            maximumFruits = Math.max(maximumFruits, end - start);
        }
        return maximumFruits;
    }
}
