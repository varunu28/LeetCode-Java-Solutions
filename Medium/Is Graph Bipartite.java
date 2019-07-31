class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) {
                stack.push(i);
                colors[i] = 0;
                
                while (!stack.isEmpty()) {
                    Integer removed = stack.pop();
                    for (Integer connect : graph[removed]) {
                        if (colors[connect] == -1) {
                            stack.push(connect);
                            colors[connect] = colors[removed] == 1 ? 0 : 1;
                        }
                        else if (colors[connect] == colors[removed]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
