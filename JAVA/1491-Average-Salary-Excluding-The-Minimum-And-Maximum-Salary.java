class Solution {
    public double average(int[] salary) 
    {
        int max=salary[0];
        int min= salary[0];
        int sum=0;
        for(int i=0;i<salary.length;i++){
            sum= sum+salary[i];
            if(salary[i]>max)
            {
                max=salary[i];
            }
            else if(salary[i]<min)
            {
                min=salary[i];
            }
        }
        sum= sum-(max+min);
        return (double)sum/(salary.length-2);

    }
}
