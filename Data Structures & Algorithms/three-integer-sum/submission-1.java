class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if(n<3){
            return new ArrayList<>();
        }
        for(int i=0; i<n-2; i++){
            int start=i+1;
            int end=n-1;
            while(start<end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum==0){
                     set.add(Arrays.asList(nums[i],nums[start],nums[end]));
                     start++;
                     end--;
                }
                else if(sum<0){
                    start++;
                }
                else{
                    end--;
                }
            }
            
}
return new ArrayList<>(set);
}
}
