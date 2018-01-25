class Solution {
    public List<Integer> grayCode(int n) {
          
        if (n == 0) {
            List<Integer> ans = Arrays.asList(0); 
            return ans;
        } 
        
        List<String> arr = new ArrayList<>();
        
        // Base case for 1
        arr.add("0");
        arr.add("1");
        
        int c = 1;
        while(c < n) {
            
            for (int i=0;i<arr.size();i++) {
                arr.set(i, "0" + arr.get(i));
            }
            
            int rev = arr.size()-1;
            while (rev >= 0) {
                arr.add("1" + arr.get(rev).substring(1));
                rev--;
            }
            
            c++;
        }
        
        List<Integer> ans = getDecimalList(arr);
        
        return ans;
    }
    
    public List<Integer> getDecimalList(List<String> arr) {
        List<Integer> ans = new ArrayList<>();
        
        for (String s : arr) {
            ans.add(Integer.parseInt(s, 2));
        }
        
        return ans;
    }
}
