class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int result = Integer.MAX_VALUE;
        int minManhattanDistance = Integer.MAX_VALUE;
        for (int i = 0; i < drones.length; i++) {
            int distance = findDistance(target, drones[i][0], drones[i][1]);
            if (distance <= drones[i][2] && distance < minManhattanDistance) {
                minManhattanDistance = distance;
                result = i;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int findDistance(int[] p1, int x, int y) {
        return Math.abs(p1[0] - x) + Math.abs(p1[1] - y);
    }
}
