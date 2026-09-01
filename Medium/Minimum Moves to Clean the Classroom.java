class Solution {

    private static final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int minMoves(String[] classroom, int energy) {
        int rows = classroom.length;
        int cols = classroom[0].length();
        int[][] indices = new int[rows][cols];
        int startX = 0;
        int startY = 0;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    indices[i][j] = 1 << count;
                    count++;
                }
            }
        }
        int full = 1 << count;
        int[][][] bestEnergy = new int[rows][cols][full];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(bestEnergy[i][j], -1);
            }
        }
        bestEnergy[startX][startY][0] = energy;
        Deque<Info> queue = new ArrayDeque<>();
        queue.addLast(new Info(startX, startY, 0, energy, 0));
        while (!queue.isEmpty()) {
            Info removed = queue.removeFirst();
            if (removed.mask == full - 1) {
                return removed.steps;
            }
            if (removed.energy == 0) {
                continue;
            }
            for (int[] dir : DIRS) {
                int newX = removed.x + dir[0];
                int newY = removed.y + dir[1];
                if (
                    newX < 0 || 
                    newY < 0 || 
                    newX >= rows || 
                    newY >= cols || 
                    classroom[newX].charAt(newY) == 'X') {
                    continue;
                }
                int newEnergy = classroom[newX].charAt(newY) == 'R' ? energy : removed.energy - 1;
                int newMask = removed.mask | indices[newX][newY];
                if (newEnergy > bestEnergy[newX][newY][newMask]) {
                    bestEnergy[newX][newY][newMask] = newEnergy;
                    queue.addLast(new Info(newX, newY, newMask, newEnergy, removed.steps + 1));
                }
            }
        }
        return -1;
    }

    private class Info {
        int x;
        int y;
        int mask;
        int energy; 
        int steps;

        public Info(int x, int y, int mask, int energy, int steps) {
            this.x = x;
            this.y = y;
            this.mask = mask;
            this.energy = energy;
            this.steps = steps;
        }
    }
}
