class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int[][] newPath = getPath(graph);

        int start = 0;
        int destination = newPath.length-1;

        List<List<Integer>> ans = printPossiblePaths(newPath, start, destination);
        
        return ans;
    }
    
    private static int[][] getPath(int[][] graph) {
        int[][] path = new int[graph.length][graph.length];

        for (int i=0; i<graph.length; i++) {
            for (int j=0; j<graph[i].length; j++) {
                path[i][graph[i][j]] = 1;
            }
        }

        return path;
    }
    
    public List<List<Integer>> printPossiblePaths(int[][] paths, int start, int destination) {
        List<List<Integer>> ans = new ArrayList<>();
        printPossiblePathsHelper(paths, start, destination, new StringBuilder().append(start).append("-"), ans);

        return ans;
    }

    private void printPossiblePathsHelper(int[][] paths, int start, int destination, StringBuilder sb, List<List<Integer>> ans) {
        int[] possiblePaths = paths[start];
        if (start == destination) {
            List<Integer> list = Arrays.
                                    stream(sb.toString().split("-")).
                                    mapToInt(Integer::parseInt).
                                    boxed().
                                    collect(Collectors.toList());
            
            ans.add(list);
            return;
        }

        for (int i=0; i<possiblePaths.length; i++) {
            if (possiblePaths[i] == 1 && sb.indexOf(String.valueOf(i)) == -1) {
                printPossiblePathsHelper(paths, i, destination, new StringBuilder().append(sb.toString()).append(i).append("-"), ans);
            }
        }
    }
}
