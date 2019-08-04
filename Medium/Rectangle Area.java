class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = ((D - B) * (C - A)) + ((H - F) * (G- E));
        area -= overlap(A, C, E, G) * overlap(B, D, F, H);
        return area;
    }
    
    private int overlap(int x1, int x2, int x3, int x4) {
        if (x2 <= x3) {
            return 0;
        }
        
        if (x1 >= x4) {
            return 0;
        }
        
        return Math.min(x2, x4) - Math.max(x1, x3);
    }
}
