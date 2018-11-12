class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> rows = new TreeMap<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            rows.computeIfAbsent(x , z -> new ArrayList<>()).add(y);
        }

        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> lastIdx = new HashMap<>();
        for (int key : rows.keySet()) {
            List<Integer> row = rows.get(key);
            Collections.sort(row);

            for (int i=0; i<row.size(); i++) {
                for (int j=i+1; j<row.size(); j++) {
                    int y1 = row.get(i);
                    int y2 = row.get(j);
                    int code = 40001 * y1 + y2;
                    if (lastIdx.containsKey(code)) {
                        ans = Math.min(ans, (key - lastIdx.get(code)) * (y2 - y1));
                    }
                    
                    lastIdx.put(code, key);
                }
            }
        }

        return ans < Integer.MAX_VALUE ? ans : 0;
    }
}
