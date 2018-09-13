class Solution {
    
    //Using DP
    //https://leetcode.com/problems/longest-valid-parentheses/discuss/14133/My-DP-O(n)-solution-without-using-stack
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        if (s == null || s.length() == 0) return maxLength;
        int[] dp = new int[s.length()]; //dp[i] stores the longest valid parentheses containing s.charAt(i);
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // There will never be a valid substring ending in '('
                dp[i] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2) ? dp[i - 2] + 2 : 2;
                } else if (s.charAt(i - 1) == ')') {
                    
                    if (dp[i - 1] == (i - 1) && s.charAt(0) == '(') {
                        dp[i] = dp[i - 1] + 2;
                    } else if (dp[i - 1] < (i - 1) && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                    } else {
                        dp[i] = 0;
                    }
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        return maxLength;
    }
    
    //Using Stack
    //https://leetcode.com/problems/longest-valid-parentheses/discuss/14126/My-O(n)-solution-using-a-stack
//     public int longestValidParentheses(String s) {
//         int maxLength = 0;
//         if (s == null || s.length() == 0) return maxLength;
//         int left = 0;
//         Stack<Integer> stack = new Stack<>();
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '(') {
//                 stack.push(i);
//             } else {
//                 if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
//                     stack.pop();
//                 } else {
//                     stack.push(i);
//                 }
//             }
//         }
//         if (stack.isEmpty()) {
//             return s.length();
//         }
        
//         int b = s.length();
//         while (! stack.isEmpty()) {
//             int a = stack.pop();
//             maxLength = Math.max((b - a - 1), maxLength);
//             b = a;
//         }
//         maxLength = Math.max(b, maxLength);
//         return maxLength;
//     }
}