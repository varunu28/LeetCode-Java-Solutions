class Solution {
    public boolean isReflected(int[][] points) {
        Set<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int[] point : points) {
            set.add(new StringBuilder()
                            .append(point[0])
                            .append("|")    
                            .append(point[1])
                            .toString());
            
            min = Math.min(min, point[0]);
            max = Math.max(max, point[0]);
        }
        
        int totalLength = max + min;
        
        for (int[] point : points) {
            String key = new StringBuilder()
                            .append(totalLength - point[0])
                            .append("|")    
                            .append(point[1])
                            .toString();
            if (!set.contains(key)) {
                return false;
            }
        }
        
        return true;
    }
}
