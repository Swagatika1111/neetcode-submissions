class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int start=0;
        int end=0;
        int maxFrequency=0;
        int maxLength=0;
        Map<Character,Integer> map = new HashMap<>();
        while(end<n){
            char ch = s.charAt(end);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxFrequency=Math.max(maxFrequency,map.get(ch));
            while((end-start+1)-maxFrequency > k){
                char leftChar = s.charAt(start);
                map.put(leftChar,map.get(leftChar)-1);
                start++;
            }
            int windowLength = end - start + 1;
            maxLength=Math.max(maxLength,windowLength);
            end++;
        }
        return maxLength;
    }
}
