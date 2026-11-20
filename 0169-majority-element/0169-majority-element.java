class Solution {
    public int majorityElement(int[] nums) {
       //Method 1
        // Arrays.sort(nums);
        // int n=nums.length;
        // return nums[n/2];
        // Method 2
        int c=0;int cand=0;
        for(int i:nums){
                if(c==0)cand=i;
                if(cand==i)c--;
                else c++;
        }
        return cand;
    }
}