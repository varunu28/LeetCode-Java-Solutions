class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int idx = -1; 
        int maxQuality = -1;  
        for (int i = 0; i < towers.length; i++) {
            int currX = towers[i][0];
            int currY = towers[i][1];
            int distance = manhattanDistance(new int[]{currX, currY}, center);
            if (distance > radius) {
                continue;
            }
            int quality = towers[i][2];
            if (quality > maxQuality) {
                maxQuality = quality;
                idx = i;
            } else if (quality == maxQuality) {
                if (currX < towers[idx][0] || (currX == towers[idx][0] && currY < towers[idx][1])) {
                    idx = i;
                }
            }
        }
        return idx == -1 ? new int[]{-1, -1} : new int[]{towers[idx][0], towers[idx][1]};
    }

    private static int manhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
