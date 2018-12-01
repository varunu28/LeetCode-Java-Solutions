class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int rec1X1 = rec1[0];
        int rec1X2 = rec1[2];
        int rec1Y1 = rec1[1];
        int rec1Y2 = rec1[3];
        
        int rec2X1 = rec2[0];
        int rec2X2 = rec2[2];
        int rec2Y1 = rec2[1];
        int rec2Y2 = rec2[3];
        
        return !(
                    rec1X1 >= rec2X2 ||
                    rec1X2 <= rec2X1 ||
                    rec1Y2 <= rec2Y1 ||
                    rec1Y1 >= rec2Y2
                );
    }
}
