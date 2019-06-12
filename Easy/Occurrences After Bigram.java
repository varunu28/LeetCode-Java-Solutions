class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split("\\s+");
        List<Integer> indexes = new ArrayList<>();
        
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                indexes.add(i + 2);
            }
        }
        
        String[] ans = new String[indexes.size()];
        for (int i = 0; i < indexes.size(); i++) {
            ans[i] = words[indexes.get(i)];
        }
        
        return ans;
    }
}
