class Solution {
    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int oddVal = 0;
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue()%2 != 0) {
                oddVal++;
            }
            
            if (oddVal == 2) {
                return false;
            }
        }
        
        return true;
    }
}
