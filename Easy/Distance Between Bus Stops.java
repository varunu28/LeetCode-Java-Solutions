class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) {
            return 0;
        }
        int n = distance.length;
        int actualStart = Math.min(start, destination);
        int actualDestination = Math.max(start, destination);
        return Math.min(
            getStraightDistance(distance, actualStart, actualDestination, n), 
            getReverseDistance(distance, actualDestination, actualStart, n)
        );
    }
    
    private int getStraightDistance(int[] distance, int start, int end, int n) {
        int dist = 0;
        while (start != end) {
            dist += distance[start++];
        }
        return dist;
    }
    
    private int getReverseDistance(int[] distance, int end, int start, int n) {
        int dist = 0;
        while (end != start) {
            dist += distance[end++];
            end = end % n;
        }
        return dist;
    }
}
