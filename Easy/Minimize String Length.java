class Solution {
    public int minimizedStringLength(String s) {
        return (int) s.chars()
            .distinct()
            .count();
    }
}
