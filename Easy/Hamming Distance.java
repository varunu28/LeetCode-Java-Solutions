class Solution {
    public int hammingDistance(int x, int y) {
        return findCount(x,y);
    }
    public int findCount(int x, int y) {
        StringBuilder sbX = new StringBuilder("");
        StringBuilder sbY = new StringBuilder("");
        
        while (x>0) {
            sbX.append(String.valueOf(x%2));
            x /= 2;
        }
        
        while (y>0) {
            sbY.append(String.valueOf(y%2));
            y /= 2;
        }
        
        String binX = sbX.reverse().toString();
        String binY = sbY.reverse().toString();
    
        if (binX.length() > binY.length()) {
            int d = binX.length() - binY.length();
            while (d>0) {
                binY = "0" + binY;
                d--;
            }
        }
        else if (binX.length() < binY.length()) {
            int d = binY.length() - binX.length();
            while (d>0) {
                binX = "0" + binX;
                d--;
            }
        }
        
        int count = 0;
        for (int i=0;i<binX.length();i++) {
            if (binX.charAt(i) != binY.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}