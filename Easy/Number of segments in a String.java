class Solution {
    public int countSegments(String str) {
        String[] arr = str.split("\\s+");
        
        int count = 0;
        for (String s : arr) {
            if ((!s.equals("\\s+")) && s.length() > 0) {
                count++;
            }
        }
        
        return count;
    }
}
