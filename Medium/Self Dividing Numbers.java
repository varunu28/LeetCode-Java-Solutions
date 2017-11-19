class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        while(left <= right) {
            if(selfDivide(left)) {
                arr.add(left);
            }
            left++;
        }
        
        return arr;
    }
    
    private boolean selfDivide(int n) {
        int copy = n;
        while(n>0) {
            int rem = n%10;
            if (rem == 0) return false;
            if(copy%rem != 0) {
                return false;
            }
            n /= 10;
        }
        
        return true;
    }
}
