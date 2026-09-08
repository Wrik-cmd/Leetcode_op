class Solution {
    public int countCommas(int n) {
        // int c=0;
        // for(int  i=1;i<=n;i++){
        //     if(i>=1000)c++;
        // }
        // return c;
        if(n<1000) return 0;

        return n-999;
    }
}