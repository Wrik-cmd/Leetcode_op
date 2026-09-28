class Solution {
    public int maxDepth(String s) {
        int d=0;
        int md=0;

        for(char c:s.toCharArray()){
            if(c=='('){
                d++;
                md=Math.max(md,d);
            }
            else if(c==')'){
                d--;
            }
        }
        return md;
    }
}