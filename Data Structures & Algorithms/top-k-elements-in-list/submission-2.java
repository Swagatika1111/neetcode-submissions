

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(map.get(i2), map.get(i1));
            }
        });

        for (int j = 0; j < k; j++) {
            res[j] = list.get(j);
        }

        return res;
    }
}