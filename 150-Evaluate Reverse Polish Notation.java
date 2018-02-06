class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int sec = stack.pop();
                int fir = stack.pop();
                int res = fir + sec;
                stack.push(res);
            } else if (tokens[i].equals("-")) {
                int sec = stack.pop();
                int fir = stack.pop();
                int res = fir - sec;
                stack.push(res);
            } else if (tokens[i].equals("*")) {
                int sec = stack.pop();
                int fir = stack.pop();
                int res = fir * sec;
                stack.push(res);
            }else if (tokens[i].equals("/")) {
                int sec = stack.pop();
                int fir = stack.pop();
                int res = fir / sec;
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}