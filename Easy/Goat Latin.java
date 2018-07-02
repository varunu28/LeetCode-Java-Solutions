class Solution {
    public static String toGoatLatin(String S) {
    	
    	StringBuilder sb = new StringBuilder("");
    	String[] strs = S.split("\\s+");
    	
    	String vowels = "aeiou";
    	StringBuilder suffix = new StringBuilder("a");
    	
    	for (String s : strs) {
    		if (vowels.indexOf(s.toLowerCase().charAt(0)) != -1) {
    			sb.append(s).append("ma").append(suffix).append(" ");
    		}
    		else {
    			sb.append(s.substring(1, s.length())).append(s.charAt(0)).append("ma").append(suffix).append(" ");
    		}
    		
    		suffix.append("a");
    	}
        
        return sb.toString().trim();
    }
}

