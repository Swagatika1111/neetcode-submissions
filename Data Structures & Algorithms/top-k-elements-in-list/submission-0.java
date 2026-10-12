class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[k];

        for(int i=0; i<n; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> keys = new ArrayList<Integer>(map.keySet());

        Collections.sort(keys, new Comparator<Integer>() {
            public int compare(Integer k1, Integer k2) {
                return map.get(k2) - map.get(k1);
            }
        });
        for(int j=0;j<k;j++){
            res[j]=keys.get(j);
        }
        return res;
    }
}
