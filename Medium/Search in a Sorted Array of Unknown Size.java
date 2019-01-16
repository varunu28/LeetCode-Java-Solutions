class Solution {
    public int search(ArrayReader reader, int target) { 
        int highIdx = 1;
        while (reader.get(highIdx) < target) {
            highIdx = highIdx * 2;
        }
        
        int lowIdx = highIdx / 2;
        
        while (lowIdx <= highIdx) {
            int mid = (highIdx + lowIdx) / 2;
            if (reader.get(mid) == target) {
                return mid;
            }
            else if (reader.get(mid) > target) {
                highIdx = mid - 1;
            }
            else {
                lowIdx = mid + 1;
            }
        }
        
        return -1;
    }
}
