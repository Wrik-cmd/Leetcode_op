class Solution {
    public int singleNumber(int[] nums) {
        int one = 0, twos = 0;

        for (int n : nums) {
            one = (one ^ n) & ~twos;
            twos = (twos ^ n) & ~one;
        }

        return one;
    }
}