class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        visited.add("0|0");
        int x = 0;
        int y = 0;
        for (Character step : path.toCharArray()) {
            switch (step) {
                case 'N':
                    x++;
                    break;
                case 'S':
                    x--;
                    break;
                case 'E':
                    y--;
                    break;
                case 'W':
                    y++;
                    break;
            }
            String key = x + "|" + y;
            if (!visited.add(key)) {
                return true;
            }
        }
        return false;
    }
}
