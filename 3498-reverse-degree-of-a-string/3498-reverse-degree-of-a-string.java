class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int rv=26-(c-'a');
            int p=i+1;
            sum+=rv*p;
        }
        return sum;
    }
}