class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack st = new Stack();
        char last;
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='[') {
                st.push(c);
            } else {
                if(st.size() == 0) return false;
                if(c==')' && (char)st.peek()!='(')  return false;
                if(c==']' && (char)st.peek()!='[')  return false;
                if(c=='}' && (char)st.peek()!='{')  return false;
                st.pop();
            }
        }
        return st.empty();
    }
}