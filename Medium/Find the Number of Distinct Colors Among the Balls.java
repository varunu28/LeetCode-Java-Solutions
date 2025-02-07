class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballToColor = new HashMap<>();
        Map<Integer, Integer> colorToBallCount = new HashMap<>();
        int n = queries.length;
        int[] result = new int[n];
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            if (ballToColor.containsKey(ball)) {
                int prevColor = ballToColor.get(ball);
                colorToBallCount.put(prevColor, colorToBallCount.get(prevColor) - 1);
                if (colorToBallCount.get(prevColor) == 0) {
                    colorToBallCount.remove(prevColor);
                }
            }
            ballToColor.put(ball, color);
            colorToBallCount.put(color, colorToBallCount.getOrDefault(color, 0) + 1);
            result[i] = colorToBallCount.size();
        }
        return result;
    }
}
