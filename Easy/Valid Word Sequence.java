class Solution {
    public boolean validWordSquare(List<String> words) {
        List<String> vertical = getStrings(words);
        
        for (int i=0; i<words.size(); i++) {
            if (!words.get(i).equals(vertical.get(i))) {
                return false;
            }
        }
        
        return true;
    }
    
    private List<String> getStrings(List<String> strings) {
        List<String> list = new ArrayList<>();
        
        for (int i=0; i<strings.size(); i++) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < strings.size()) {
                if (i < strings.get(j).length()) {
                    sb.append(strings.get(j).charAt(i));
                }
                
                j++;
            }

            list.add(sb.toString());
        }
        
        return list;
    }
}
