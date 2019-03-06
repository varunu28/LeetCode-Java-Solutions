class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        
        char[] charSet = {'A', 'C', 'G', 'T'};
        int currLevel = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.add(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.remove();
                if (curr.equals(end)) {
                    return currLevel;
                }
                
                char[] currCharArr = curr.toCharArray();
                for (int i = 0; i < currCharArr.length; i++) {
                    char old = currCharArr[i];
                    for (char c : charSet) {
                        currCharArr[i] = c;
                        String newGene = String.valueOf(currCharArr);
                        if (!visited.contains(newGene) && bankSet.contains(newGene)) {
                            queue.add(newGene);
                            visited.add(newGene);
                        }
                    }
                    currCharArr[i] = old;
                }
            }
            
            currLevel++;
        }
        
        return -1;
    }
}
