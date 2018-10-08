class Solution {
    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        int ptr = 0;
        int res = 0;
        char sign = '+'; //record the sign before the number
        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (cur == ' ') {
                ptr++;
            } else if (cur == '+' || cur == '-' || cur == '*' || cur == '/') {
                sign = cur;
                ptr++;
            } else if (Character.isDigit(cur)) {
                int number = 0;
                while (ptr < s.length() && Character.isDigit(s.charAt(ptr))) {
                    number = 10 * number + s.charAt(ptr) - '0';
                    ptr++;
                }
                if (sign == '*') {
                    int number2 = stack.pop();
                    stack.push(number2 * number);
                } else if (sign == '/') {
                    int number2 = stack.pop();
                    stack.push(number2 / number);
                } else if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-number);
                }
                sign = '+';
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}