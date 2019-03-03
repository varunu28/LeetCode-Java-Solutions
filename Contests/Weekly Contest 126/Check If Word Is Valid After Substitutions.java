class Solution {
    public boolean isValid(String S) {
        int[] counter = new int[3];

        for (char c : S.toCharArray()) {
            counter[c - 'a']++;

            if (counter[2] > counter[1] || counter[2] > counter[0] || counter[1] > counter[0]) {
                return false;
            }
        }
        
        return counter[1] == counter[0]  && counter[0] == counter[2];
    }
}
