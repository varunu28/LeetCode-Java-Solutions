class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] mins = new int[timePoints.size()];
        int i = 0;
        for (String s : timePoints) {
            int hr = Integer.parseInt(s.split(":")[0]);
            int ms = Integer.parseInt(s.split(":")[1]);
            
            mins[i] = hr*60 + ms;
            i++;
        }
        
        Arrays.sort(mins);
        
        int minTime = Integer.MAX_VALUE;
        
        for(int j=1;j<mins.length;j++) {
            minTime = Math.min(minTime, mins[j] - mins[j-1]);
        }

        return Math.min(minTime, mins[0] + 1440 - mins[mins.length-1]);
    }
}
