class Solution {
    
    int[] relation;
    public boolean equationsPossible(String[] equations) {
        relation = new int[26];
        List<Integer> notEqual = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            relation[i] = i;
        }
        
        for (int i = 0; i < equations.length; i++) {
            String equation = equations[i];
            if (equation.charAt(1) == '=') {
                union((int) equation.charAt(0) - 'a', (int) equation.charAt(3) - 'a');
            }
            else {
                notEqual.add(i);
            }
        }
        
        for (int idx : notEqual) {
            String equation = equations[idx];
            int first = (int) equation.charAt(0) - 'a';
            int second = (int) equation.charAt(3) - 'a';
            
            if (getRoot(first) == getRoot(second)) {
                return false;
            }
        }
        
        return true;
    }
    
    private int getRoot(int n) {
        while (relation[n] != n) {
            relation[n] = relation[relation[n]];
            n = relation[n];
        }
        
        return n;
    }
    
    private void union(int a, int b) {
        int rootA = getRoot(a);
        int rootB = getRoot(b);
        if (rootA != rootB) {
            relation[rootA] = rootB;
        }
    }
}
