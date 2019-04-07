class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        
        for (String query : queries) {
            ans.add(check(query, pattern));
        }
        
        return ans;
    }
    
    private boolean check(String query, String pattern) {
        int qIdx = 0;
        int pIdx = 0;
        int qLen = query.length();
        int pLen = pattern.length();
        
        while (qIdx < qLen && pIdx < pLen) {
            if (query.charAt(qIdx) == pattern.charAt(pIdx)) {
                qIdx++;
                pIdx++;
            }
            else {
                if (Character.isUpperCase(query.charAt(qIdx))) {
                    return false;
                }
                else {
                    qIdx++;
                }
            }
        }
        
        while (qIdx < qLen) {
            if (Character.isUpperCase(query.charAt(qIdx))) {
                return false;
            }
            
            qIdx++;
        }
        
        return pIdx == pLen;
    }
}
