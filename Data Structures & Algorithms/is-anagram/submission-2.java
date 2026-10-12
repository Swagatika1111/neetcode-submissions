class Solution {
    public boolean isAnagram(String s, String t) {
            int n = s.length();
            int m = t.length();
            if(n!=m) return false;
            char[] ch1 = s.toCharArray();
            char[] ch2 = t.toCharArray();

            Arrays.sort(ch1);
            Arrays.sort(ch2);

            for(int i=0;i<n;i++){
                if(ch1[i]!=ch2[i]){
                    return false;
                }
            }
            return true;
    }
}
