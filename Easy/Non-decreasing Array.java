class Solution {
    public boolean checkPossibility(int[] a) {
        int c = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                if (c++ > 0) return false;
                if (i - 2 < 0 || a[i - 2] <= a[i]) a[i - 1] = a[i];  
                else a[i] = a[i - 1];  
            }
        }
        return true;
    }
}
