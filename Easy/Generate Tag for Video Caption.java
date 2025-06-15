class Solution {
    public String generateTag(String caption) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        int idx = 0;
        int n = caption.length();
        while (idx < n && caption.charAt(idx) == ' ') {
            idx++;
        }
        boolean upperCase = false;
        while (idx < n) {
            if (Character.isLetter(caption.charAt(idx))) {
                if (upperCase) {
                    sb.append(Character.toUpperCase(caption.charAt(idx)));
                    upperCase = false;
                } else {
                    sb.append(Character.toLowerCase(caption.charAt(idx)));
                }
            } else if (caption.charAt(idx) == ' ') {
                upperCase = true;
            }
            idx++;
        }
        return sb.toString().substring(0, Math.min(sb.length(), 100));
    }
}
