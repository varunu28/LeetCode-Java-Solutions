class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] strA = a.trim().split("\\+");
        String[] strB = b.trim().split("\\+");
        
        int realA = Integer.parseInt(strA[0]);
        int realB = Integer.parseInt(strB[0]);
        
        int compA = Integer.parseInt(strA[1].substring(0,strA[1].length()-1));
        int compB = Integer.parseInt(strB[1].substring(0,strB[1].length()-1));
        
        int realAns = (realA*realB) - (compA*compB);
        int compAns = (realA*compB) + (realB*compA);
        
        return String.valueOf(realAns) + "+" + String.valueOf(compAns) + "i";
    }
}
