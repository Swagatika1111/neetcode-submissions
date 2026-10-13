class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Map<Integer,Boolean> map = new HashMap<>();
        int longest=0;

        for(Integer num: nums){
            map.put(num,Boolean.FALSE);
        }

        for(Integer num: nums){
            map.put(num,Boolean.TRUE);
            int count=1;
            int nextNum=num+1;
            int prevNum=num-1;
            //greater than number
            while(map.containsKey(nextNum) && !map.get(nextNum)){
                count++;
                map.put(nextNum,Boolean.TRUE);
                nextNum=nextNum+1;
            }

            //less than number
            while(map.containsKey(prevNum) && !map.get(prevNum)){
                count++;
                map.put(prevNum,Boolean.TRUE);
                prevNum=prevNum-1;
            }
            longest=Math.max(longest,count);
        }
        return longest;
    }
}
