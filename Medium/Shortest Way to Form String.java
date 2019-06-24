class Solution {
    public int shortestWay(String source, String target) {
        int idx = 0;
        int count = 0;
        int n = target.length();
        while (idx < n) {
            int slow = idx;
            
            for (char c : source.toCharArray()) {
                if (idx < n && c == target.charAt(idx)) {
                    idx++;
                }
            }
            
            if (slow == idx) {
                return -1;
            }
            
            count++;
        }
        
        return count;
    }
}
