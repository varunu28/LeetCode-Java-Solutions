class Solution {
    public static int[] shortestToChar(String S, char C) {
    	int[] ans = new int[S.length()];
    	
    	int count = (int) S.chars().filter(ch -> ch == C).count();
    	
    	int[] Cindexes = new int[count];
    	int[] indexes = new int[S.length()];
    	
    	int i = 0;
    	
    	for (int j=0; j<S.length(); j++) {
    		if (S.charAt(j) == C) {
    			Cindexes[i++] = j; 
    		}
    		
    		indexes[j] = j;
    	}
    	
    	for (int j=0; j<S.length(); j++) {
    		ans[j] = findMin(Cindexes, indexes[j]);
    	}
    	
    	return ans;
    }

	private static int findMin(int[] cindexes, int i) {
		int minDist = Integer.MAX_VALUE;
		
		for (int index : cindexes) {
			minDist = Math.min(minDist, Math.abs(index - i));
		}
		
		return minDist;
	}
}
