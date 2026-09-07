class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n =nums.length;
        Map<Integer,Integer>NM=new HashMap<>();
        for(int i=0;i<n;i++){
            int y=target-nums[i];
            if(NM.containsKey(y)){
                return new int[]{NM.get(y),i};

            }
            NM.put(nums[i],i);

        }
        return new int[]{};//empty soln

    }
}