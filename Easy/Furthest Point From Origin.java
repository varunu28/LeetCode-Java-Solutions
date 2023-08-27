class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int emptyCount = 0;
        int direction = 0;
        for (char c : moves.toCharArray()) {
            if (c == '_') {
                emptyCount++;
            } else {
                direction += c == 'L' ? -1 : 1;
            }
        }
        return Math.abs(direction) + emptyCount;
    }
}
