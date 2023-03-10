class Solution {
    public int shortestWay(String source, String target) {
        Set<Character> letters = source.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        int count = 0;
        int sourceIdx = 0;
        int targetIdx = 0;
        while (targetIdx < target.length()) {
            char targetLetter = target.charAt(targetIdx);
            if (!letters.contains(targetLetter)) {
                return -1;
            }
            if (targetLetter == source.charAt(sourceIdx)) {
                targetIdx++;
            }
            sourceIdx++;
            if (sourceIdx == source.length()) {
                sourceIdx = 0;
                count++;
            }
        }
        return count + (sourceIdx == 0 ? 0 : 1);
    }
}
