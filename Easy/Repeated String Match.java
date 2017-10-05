class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int n = 0;
        while(sb.length() < B.length()) {
            sb.append(A);
            n++;
        }
        if (sb.toString().contains(B)) return n;
        if (sb.append(A).toString().contains(B)) return n+1;
        
        return -1;
    }
}
