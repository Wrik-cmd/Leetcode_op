class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int t=0;
        int z=0;

        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)z++;
            else if(nums[i]==2)t++;

        }

          for(int i=0;i<n;i++)
        {
            if(i<z)nums[i]=0;
            else if(i>=n-t)nums[i]=2;
            else  nums[i]=1;

            
        }
    }
}