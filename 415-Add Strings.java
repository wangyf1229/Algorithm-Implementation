class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            int sum = carry;
            int idx1 = num1.length() - i - 1;
            int idx2 = num2.length() - i - 1;
            if (idx1 >= 0) sum += num1.charAt(idx1) - '0';
            if (idx2 >= 0) sum += num2.charAt(idx2) - '0';
            sb.append(sum % 10);
            carry = sum/10;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}