class Solution {
    public boolean isFascinating(int n) {
        return isFascinatingHelper(n + "" + 2 * n + "" + 3 * n);
    }
    
    private boolean isFascinatingHelper(String s) {
        return s.length() == 9 && s.chars()
            .mapToObj(c -> (char)  c)
            .filter(c -> c != '0')
            .collect(Collectors.toSet())
            .size() == 9;
    }
}
