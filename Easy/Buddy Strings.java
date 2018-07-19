class Solution {
	public static boolean buddyStrings(String A, String B) {
	    if (A.length() != B.length() || A.length() <= 1 || B.length() <= 1) {
	        return false;
	    }
        
        if (A.equals(B)) {
            Set<Character> s = new HashSet<Character>();
            for (char c : A.toCharArray()) {
                s.add(c);
            }
            
            return s.size() < A.length();
        }
        
        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) != B.charAt(i)) {
                dif.add(i);
            }
        }
        
        return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && A.charAt(dif.get(1)) == B.charAt(dif.get(0)); 
	}
}
