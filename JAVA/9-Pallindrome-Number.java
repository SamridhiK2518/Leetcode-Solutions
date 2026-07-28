class Solution {
    public boolean isPalindrome(int x) 
    {
        if(x<0)
        return false;
        else
        {
        int m=x;
        int sum=0;
        while(x!=0)
        {
            int d= x%10;
            sum=sum*10+d;
            x= x/10;
        }
        if(m==sum)
        return true;
        else
        return false;
        }
    }
}
