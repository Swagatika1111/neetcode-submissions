class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start=0;
        int end=0;
        int longest=0;
        Map<Character,Integer> map = new HashMap<>();

        while(end<n){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                if(map.get(ch)>=start){
                    start=map.get(ch)+1;
                }
            }
            map.put(ch,end);
            int length=end-start+1;

            end++;
            longest=Math.max(length,longest);
        }
        return longest;
    }
}

