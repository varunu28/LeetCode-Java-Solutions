class Solution {
    public boolean isStrobogrammatic(String num) {
        Set<String> set = new HashSet<>();
        set.add("0");
        set.add("1");
        set.add("8");
        set.add("00");
        set.add("11");
        set.add("88");
        set.add("69");
        set.add("96");
                
        int start = 0;
        int end = num.length()-1;
        
        while (start <= end) {
            if (!set.contains(num.charAt(start) + "" + num.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}
