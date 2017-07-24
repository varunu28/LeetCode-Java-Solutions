public class Main {
    static void moveZeroes(int[] nums) 
    {
        int n =nums.length;
        int[] ans=new int[n];
        int count=0;
        int k=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=0)
            {
                ans[k]=nums[i];
                k++;
                count++;
            }
        }
        
        count++;
        while(count<n)
        {
            ans[count]=0;
            count++;
        }
        for(int i=0;i<n;i++)
        {
            nums[i]=ans[i];
        }
        
    }