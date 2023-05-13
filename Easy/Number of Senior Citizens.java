class Solution {
    public int countSeniors(String[] details) {
        return (int) Arrays.stream(details)
            .map(s -> Integer.parseInt(s.substring(11, 13)))
            .filter(age -> age > 60)
            .count();
    }
}
