class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] record = new int[256];
        int start = 0;
        int end = 0;
        int count = 0;
        int maxL = 0;
        while (end < s.length()) {
            int next = (int) s.charAt(end);
            //Add next char to the substring
            if (record[next] == 0) {
                count++;
            }
            record[next]++;
            
            //Make the substring valid
            while (count > 2) {
                int former = (int) s.charAt(start);
                record[former]--;
                if (record[former] == 0) {
                    count--;
                }
                start++;
            }

            //Record the valid substring and move the end index forward
            int len = end - start + 1;
            maxL = Math.max(len, maxL);
            end++;
        }
        return maxL;
        
    }
}