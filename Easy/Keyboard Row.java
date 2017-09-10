class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> ans = new ArrayList<String>();
        
        for (int i=0;i<words.length;i++) {
            if (canBeTyped(words[i])) {
                ans.add(words[i]);
            }
        }
        
        String[] ansArr = new String[ans.size()];
        for (int i=0;i<ansArr.length;i++) {
            ansArr[i] = ans.get(i);
        }
        
        return ansArr;
    }
    
    public boolean canBeTyped(String s) {
        s = s.toLowerCase();
        String[] keys = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        
        int keyId = 0;
        if (keys[0].indexOf(s.charAt(0)) != -1) {
            keyId = 0;
        }
        else if (keys[1].indexOf(s.charAt(0)) != -1) {
            keyId = 1;
        }
        else if (keys[2].indexOf(s.charAt(0)) != -1) {
            keyId = 2;
        }
        
        for (int i=1;i<s.length();i++) {
            if (keys[keyId].indexOf(s.charAt(i)) == -1) {
                return false;
            }
        }
        
        return true;
    }
}
