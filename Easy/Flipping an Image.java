class Solution {
	public int[][] flipAndInvertImage(int[][] A) {
        int[][] ans = new int[A.length][A[0].length];
        
        for (int i=0; i<A.length; i++) {
            List<Integer> temp = Arrays.stream(A[i]).
            							boxed().
            							collect(Collectors.toList());
            
            Collections.reverse(temp);
            ans[i] = temp.stream().mapToInt(e -> e).toArray();
        }
        
        for (int i=0;i<ans.length;i++) {
        	for (int j=0;j<ans[i].length;j++) {
        		ans[i][j] = ans[i][j] == 1 ? 0 : 1;
        	}
        }
        
        return ans;
    }
}
