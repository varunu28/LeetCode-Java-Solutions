class Solution {
    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        
        int idx = 0;
        while (idx < s.length()) {
            for (int i = 0; i < numRows && idx < s.length(); i++) {
                list.get(i).append(s.charAt(idx++));
            }
            
            for (int i = numRows - 2; i > 0 && idx < s.length(); i--) {
                list.get(i).append(s.charAt(idx++));
            }
        }
        
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : list) {
            ans.append(sb.toString());
        }
        
        return ans.toString();
    }
}
