class Solution {

    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int shortestPathAllKeys(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        int startX = -1;
        int startY = -1;
        int keyCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startX = i;
                    startY = j;
                }
                if (c >= 'a' && c <= 'f') {
                    keyCount++;
                } 
            }
        }
        Queue<Point> queue = new LinkedList<>();
        Set<Point> visited = new HashSet<>();
        int steps = 0;
        Point starting = new Point(startX, startY, Collections.emptySet());
        queue.add(starting);
        visited.add(starting);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point point = queue.remove();
                if (point.keys().size() == keyCount) {
                    return steps;
                }
                for (int[] dir : DIRS) {
                    int newX = dir[0] + point.x;
                    int newY = dir[1] + point.y;
                    Set<Character> keys = new HashSet<>(point.keys());
                    if (newX >= 0 && newY >= 0 && newX < rows && newY < cols) {
                        char c = grid[newX].charAt(newY);
                        if (c == '#') {
                            continue;
                        }
                        if (c >= 'a' && c <= 'f') {
                            keys.add(c);
                        }
                        if (c >= 'A' && c <= 'F' && !keys.contains(Character.toLowerCase(c))) {
                            continue;
                        }
                        Point newPoint = new Point(newX, newY, keys);
                        if (visited.add(newPoint)) {
                            queue.add(newPoint);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    static record Point(int x, int y, Set<Character> keys) {}
}
