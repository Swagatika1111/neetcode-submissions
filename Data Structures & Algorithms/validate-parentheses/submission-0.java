class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(Character ch: s.toCharArray()){
            if(ch=='(') st.push(')') ;
            else if(ch=='{') st.push('}') ;
            else if(ch=='[') st.push(']') ;
            else if(st.isEmpty() || st.pop()!=ch) return false;
        }
        return st.isEmpty();
    }
}
