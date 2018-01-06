class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > l2) return false;
        
        int[] check = new int[26];
        
        for (int i=0;i<l1;i++) {
            check[s1.charAt(i)-'a']++;
            check[s2.charAt(i)-'a']--;
        }
        
        if (zeroArr(check)) return true;
        
        for (int i = l1; i < l2; i++) {
            check[s2.charAt(i) - 'a']--;
            check[s2.charAt(i - l1) - 'a']++;
            if (zeroArr(check)) return true;
        }
        
        return false;
    }
    
    boolean zeroArr(int[] arr) {
        for (int i=0;i<26;i++) {
            if (arr[i] != 0) return false;
        }
        return true;
    }
}
