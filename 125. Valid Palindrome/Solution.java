class Solution {
    public boolean isPalindrome(String s) {
        int left=0, right=s.length()-1;
        while(left<right) {
            if(!isAlphaNum(s.charAt(left))) left++;
            else if(!isAlphaNum(s.charAt(right))) right--;
            else if((s.charAt(left)+32-'a')%32 != (s.charAt(right)+32-'a')%32) return false;
            else {
                left++; right--;
            }
        }
        return true;
    }
    
    public boolean isAlphaNum(char c) {
        if(c>='a' && c<='z') return true;
        if(c>='A' && c<='Z') return true;
        if(c>='0' && c<='9') return true;
        return false;
    }
}