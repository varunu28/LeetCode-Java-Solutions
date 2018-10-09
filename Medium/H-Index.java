class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int end = citations.length;
        int ind = 0;
        
        for (int i=0; i<end; i++) {
            if (citations[i] >= end - i) {
                ind = end - i;
                break;
            }
        }
        
        return ind;
    }
}
