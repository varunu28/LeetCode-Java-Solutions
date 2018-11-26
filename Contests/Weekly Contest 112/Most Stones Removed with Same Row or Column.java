class Solution {
    public int count = 0;
    public int removeStones(int[][] stones) {
        Map<String, String> map = new HashMap<>();
        count = stones.length;

        for (int[] stone : stones) {
            String key = stone[0] + " " + stone[1];
            map.put(key, key);
        }

        for (int[] stone : stones) {
            String key = stone[0] + " " + stone[1];
            for (int[] stone2 : stones) {
                if (stone2[0] == stone[0] || stone2[1] == stone[1]) {
                    String key2 = stone2[0] + " " + stone2[1];
                    union(map, key, key2);
                }
            }
        }

        return stones.length - count;
    }

    private void union(Map<String, String> map, String s1, String s2) {
        String r1 = find(map, s1);
        String r2 = find(map, s2);

        if (r1.equals(r2)) {
            return;
        }

        map.put(r1, r2);
        count--;
    }

    private String find(Map<String, String> map, String s) {
        if (!map.get(s).equals(s)) {
            map.put(s, find(map, map.get(s)));
        }

        return map.get(s);
    }
}
