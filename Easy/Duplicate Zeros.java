class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int count = 0;
        
        for (int i = 0; i < arr.length; i++, count++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            if (--count < n) {
                arr[count] = arr[i];
            }
            
            if (arr[i] == 0 && --count < n) {
                arr[count] = 0;
            }
        }
    }
}
