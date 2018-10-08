class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0) return true;
        int[] dict = new int[256];
        int count = s1.length();
        int start = 0;
        int end = 0;
        for (char c : s1.toCharArray()) {
            dict[c]++;
        }
        while (end < s2.length()) {
            char c = s2.charAt(end);
            if (dict[c] > 0) {
                count--;
            }
            dict[c]--;
            
            if (dict[c] < 0) {
                //Two cases: (1) the current char at end is in s1 but there are too many same chars before. 
                //Like there are 2 "a" in s1 but in substring between start and end there are 3 "a", 
                //so we only need to remove the first "a" 
                //(2) the current char at end is not in s1, so we need to move start to end. 
                //We combine these two conditions together.
                while (dict[c] < 0) {
                    char temp = s2.charAt(start);
                    dict[temp]++;
                    if (dict[temp] > 0) {
                        count++;
                    }
                    start++;
                }
            } else if (count == 0) {
                return true;
            }
            
            end++;
        }
        return false;
    }
}