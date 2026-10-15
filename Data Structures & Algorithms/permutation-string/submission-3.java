class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n>m){
            return false;
        }
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i=0; i<n; i++){
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }

        //initial check
        if(Arrays.equals(freq1,freq2)){
            return true;
        }

        //sliding window
        for(int i=1; i<=m-n; i++){
            freq2[s2.charAt(i-1)-'a']--; //deletion front
            freq2[s2.charAt(i+n-1)-'a']++; //addition from last

            if(Arrays.equals(freq1,freq2)){
            return true;
            }
        }
        return false;
    }
}