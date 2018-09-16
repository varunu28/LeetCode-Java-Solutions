class Solution {
    public static int totalFruit(int[] tree) {
        int maxFruits = Integer.MIN_VALUE;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;

        for (int num : tree) {
            if (map.size() < 2 || map.containsKey(num)) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                count++;
            }
            else {
                map.put(num, map.getOrDefault(num, 0) + 1);
                count++;

                while (true) {
                    int key = tree[start++];
                    map.put(key, map.get(key)-1);
                    count--;

                    if (map.get(key) == 0) {
                        map.remove(key);
                        break;
                    }
                }
            }

            maxFruits = Math.max(maxFruits, count);
        }

        return Math.max(count, maxFruits);
    }
}
