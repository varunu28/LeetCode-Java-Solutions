class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        if (citations.length == 1) {
            return citations[0] > 0 ? 1 : 0;
        }
        
        return binarySearch(citations, 0, citations.length - 1);
    }
    
    private int binarySearch(int[] citations, int start, int end) {
        int ind = -1;
        int n = end + 1;
        while (start < end) {
            int mid = (start + end) / 2 + 1;
            
            if (citations[mid] > n - mid) {
                end = mid - 1;
            }
            else {
                start = mid;
            }
        }
        
        if (citations[start] > n - start) {
            return n;
        }
        
        return citations[start] == n - start ? n - start : n - start - 1;
    }
}
