class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        
        int[] points = new int[n];
        Arrays.fill(points, -1);
        
        for (int[] edge : edges) {
            int parentPoint = getPosition(points, edge[0]);
            int childPoint = getPosition(points, edge[1]);
            
            if (parentPoint == childPoint) {
                return false;
            }
            
            points[parentPoint] = childPoint;
        }
        
        return true;
    }
    
    private int getPosition(int[] points, int num) {
        if (points[num] == -1) {
            return num;
        }
        
        return getPosition(points, points[num]);
    }
}
