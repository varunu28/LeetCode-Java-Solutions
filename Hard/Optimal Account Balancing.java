class Solution {
    int min = Integer.MAX_VALUE;
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> account = new HashMap<>();
        for (int[] transaction : transactions) {
            int amount = transaction[2];
            account.put(transaction[0], account.getOrDefault(transaction[0], 0) + amount);
            account.put(transaction[1], account.getOrDefault(transaction[1], 0) - amount);
        }
        
        LinkedList<Integer> posBalance = new LinkedList<>();
        LinkedList<Integer> negBalance = new LinkedList<>();
        
        for (Integer key : account.keySet()) {
            if (account.get(key) < 0) {
                negBalance.add(account.get(key));
            }
            else if (account.get(key) > 0) {
                posBalance.add(account.get(key));
            }
        }
        
        dfs(posBalance, negBalance, 0);
        return min;
    }
    
    private void dfs(List<Integer> posBalance, List<Integer> negBalance, int count) {
        if (posBalance.size() == 0 || negBalance.size() == 0) {
            min = Math.min(count, min);
            return;
        }
        
        if (count >= min) {
            return;
        }
        
        int posAmount = posBalance.get(0);
        
        for(int j = 0; j < negBalance.size(); j++) {
            int negAmount = negBalance.get(j);
            int newPositiveVal = Math.max(posAmount + negAmount, 0);
            int newNegativeVal = Math.min(0, posAmount + negAmount);
            if (newPositiveVal == 0){
                posBalance.remove(0);
            } 
            else {
                posBalance.set(0, newPositiveVal);
            }
            if (newNegativeVal == 0){
                negBalance.remove(j);
            }
            else{
                negBalance.set(j, newNegativeVal);
            }

            dfs(posBalance, negBalance, count + 1);
            
            if(newPositiveVal == 0){
                posBalance.add(0, posAmount);
            }
            else {
                posBalance.set(0, posAmount);
            }
            
            if(newNegativeVal == 0){
                negBalance.add(j, negAmount);
            }
            else{
                negBalance.set(j, negAmount);
            }
        }
    }
}
