class Solution {
    public int appendCharacters(String s, String t) {
        int idxS = 0;
        int idxT = 0;
        while (idxS < s.length() && idxT < t.length()) {
            if (s.charAt(idxS) == t.charAt(idxT)) {
                idxT++;
            }
            idxS++;
        }
        return idxT == t.length() ? 0 : t.length() - idxT;
    }
}
