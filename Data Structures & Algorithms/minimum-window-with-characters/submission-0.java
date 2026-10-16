class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int[] frq1 = new int[256];
        int[] frq2 = new int[256];

        for(int i=0; i<t.length(); i++){
            frq2[t.charAt(i)]++;
        }

        int left=0;
        int right=0;
        int length=0;
        int minLen=Integer.MAX_VALUE;
        int minStart=0;

        for(;right<n; right++){
            frq1[s.charAt(right)]++;

            while(contains(frq1,frq2)){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    minStart=left;
                }
                frq1[s.charAt(left)]--;
                left++;
            }
        }

        return minLen==Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);
    
    }

    public boolean contains(int[] frq1, int[] frq2){
        for(int i=0; i<256; i++){
            if(frq1[i]<frq2[i]){
                return false;
            }
        }
        return true;
    }
}
