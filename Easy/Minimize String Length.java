class Solution {
    public int minimizedStringLength(String s) {
        return s.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.toSet())
            .size();
    }
}
