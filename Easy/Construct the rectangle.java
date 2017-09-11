class Solution {
    public int[] constructRectangle(int area) {
        int[] ans = new int[2];
        
        if(area == 0){
            return ans;
        }
        
        int a = (int)Math.sqrt(area);
        while(area%a != 0) {
            a--;
        }
        
        int b = area/a;
        ans[0] = b;
        ans[1] = a;
        
        return ans;
    }
}
