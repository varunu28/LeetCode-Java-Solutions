class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String s : cpdomains) {
            String[] strs = s.split("\\s+");
            int count = Integer.parseInt(strs[0]);
            String[] domains = strs[1].split("\\.");
            
            String temp = domains[domains.length-1];
            int domainLen = domains.length-1;
            
            while(domainLen >= 0) {
                map.put(temp, map.getOrDefault(temp, 0) + count);
                if (domainLen > 0) {
                	temp = domains[domainLen-1] + "." + temp;
                }
                domainLen--;
            }
            
        }
        
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = String.valueOf(entry.getValue()) + " " + entry.getKey();
            ans.add(str);
        }
        
        return ans;
    }
}
