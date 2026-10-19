class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<strs.size();i++){
            sb.append(strs.get(i).length()).append("#").append(strs.get(i));            
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
            List<String> dec = new ArrayList<>();
            int i=0;
            while(i<str.length()){
                int j=i;
                while(str.charAt(j)!='#'){
                    j++;
                }
                int length = Integer.parseInt(str.substring(i,j));
                String s = str.substring(j+1,j+length+1);
                dec.add(s);
                i=j+length+1;
                
            }
            return dec;
    }
}
