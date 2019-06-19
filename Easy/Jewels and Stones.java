class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] isSet = new boolean[52];
        for (char c : J.toCharArray()) {
            isSet[getIdx(c)] = true;
        }
        
        int count = 0;
        for (char c : S.toCharArray()) {
            count += isSet[getIdx(c)] ? 1 : 0;    
        }
        
        return count;
    }
    
    private int getIdx(char c) {
        if (Character.isUpperCase(c)) {
            return 26 + c - 'A';
        }
        
        return c - 'a';
    }
}
