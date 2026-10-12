class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        String[] s=new String[n];
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(int i=0; i<n; i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
                
            }
          map.get(key).add(strs[i]);  
    
        }
        return new ArrayList<>(map.values());
    }
    
}
