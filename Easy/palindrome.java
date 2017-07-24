public class Solution {
    public boolean isPalindrome(int x) 
	{
        int n = x;
        int rev_x=0;
        
        while(x>0)
        {
        	rev_x=rev_x*10 + x%10;
        	x/=10;
        }
        
        if(rev_x==n)
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }
}