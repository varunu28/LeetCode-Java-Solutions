class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int max = Integer.MIN_VALUE;
        
        for (int house : houses) {
            int ind = Arrays.binarySearch(heaters, house);
            
            if (ind < 0) {
                ind = - (ind + 1);
            }
            int d1 = ind - 1 >= 0 ? house - heaters[ind - 1] : Integer.MAX_VALUE;
            int d2 = ind < heaters.length ? heaters[ind] - house : Integer.MAX_VALUE;
        
            max = Math.max(max, Math.min(d1, d2));
        }
        
        return max;
    }
}
