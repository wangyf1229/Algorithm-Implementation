class Solution {
    public boolean isNumber(String s) {
        //+/- must be at the start of s or right after e and there should be number after +/-
        //e should only appear once and should have number before and after it
        //. should appear only once and shouldn't appear after e
        
        if (s == null) return false;
        s = s.trim();
        if (s.length() == 0) return false;
        
        int index = 0;
        boolean eSeen = false;
        boolean numberBeforeE = false;
        boolean numberAfterE = false;
        boolean dotSeen = false;
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if ('0' <= cur && cur <= '9') {
                if (eSeen) {
                    numberAfterE = true;
                } else {
                    numberBeforeE = true;
                }
            } else if (cur == '.') {
                if (dotSeen || eSeen) return false;
                dotSeen = true;
            } else if (cur == 'e' || cur == 'E') {
                if (eSeen || !numberBeforeE) return false;
                eSeen = true;
            } else if (cur == '+' || cur == '-'){
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else {
                return false;
            }
        }
        return numberBeforeE && ((eSeen && numberAfterE) || (!eSeen));
    }
}