class Solution {
    public String reverseVowels(String s) {
        ArrayList<Integer> indexArr = new ArrayList<Integer>();
        String vowel = "aeiouAEIOU";
        char[] charArray = s.toCharArray();
        
        for (int i=0;i<charArray.length;i++) {
            if (vowel.indexOf(charArray[i]) != -1) {
                indexArr.add(i);
            }
        }

        int end = indexArr.size()-1;
        
        for (int i=0;i<indexArr.size();i++) {
            int ind = indexArr.get(i);
            if (ind != -1) {
                char temp = charArray[ind];
                charArray[ind] = charArray[indexArr.get(end)];
                charArray[indexArr.get(end)] = temp;
                indexArr.set(end, -1);
                end--;
            }
        }

        return new String(charArray);
    }
}
