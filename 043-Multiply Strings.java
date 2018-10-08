class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        int i = num1.length() - 1;
        //the result of num1[i] * num2[j] will be at res[i + j] and res[i + j + 1];
        while (i >= 0) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int sum = (num2.charAt(j) - '0') * (num1.charAt(i) - '0');
                //remember to add res[i + j + 1] first and then sum%10
                //because if res[i + j + 1] is 9 before and sum % 10 is 9, so after add sum%10 to res[i + j + 1], 
                //res[i + j + 1] becomes 18, but according to our definition, res[i + j + 1] should be units digit
                sum += res[i + j + 1];
                res[i + j + 1] = sum%10;
                res[i + j] += sum/10;
            }
            i--;
        }
        StringBuilder sb = new StringBuilder();        
        for (int k = 0; k < res.length; k++) {
            if (res[k] == 0 && sb.length() == 0) continue;
            sb.append(res[k]);
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}