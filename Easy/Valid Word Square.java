class Solution {
    public boolean validWordSquare(List<String> words) {
        int column = 0;
        for (String rowWord : words) {
            String columnWord = getColumnWord(words, column++);
            if (!rowWord.equals(columnWord)) {
                return false;
            }
        }
        return true;
    }
    
    private String getColumnWord(List<String> words, int column) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (column >= word.length()) {
                break;
            }
            sb.append(word.charAt(column));
        }
        return sb.toString();
    }
}
