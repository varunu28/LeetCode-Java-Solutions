class Solution {
    public int numberOfPoints(List<List<Integer>> coordinates) {
        coordinates.sort(Comparator.comparingInt((List<Integer> o) -> o.get(0)).thenComparingInt(o -> o.get(1)));
        int points = 0;
        int intervalStart = -1;
        int intervalEnd = -1;
        for (List<Integer> coordinate : coordinates) {
            if (intervalStart == -1) {
                intervalStart = coordinate.get(0);
            } else {
                if (intervalEnd < coordinate.get(0)) {
                    points += intervalEnd - intervalStart + 1;
                    intervalStart = coordinate.get(0);
                }
            }
            intervalEnd = Math.max(intervalEnd, coordinate.get(1));
        }
        return points + intervalEnd - intervalStart + 1;
    }
}
