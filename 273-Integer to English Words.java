class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int count = 0;
        String[] countArray = new String[]{"", "Thousand", "Million", "Billion"};
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            int remainder = num % 1000;
            String output = helper(remainder);
            if (!output.equals("")) {
                res.insert(0, output + " " + countArray[count] + " ");
            }
            num = num/1000;
            count++;
        }
        return res.toString().trim();
    }
    
    public String helper(int num) {
        String[] arrayUnder20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        StringBuilder sb = new StringBuilder();
        
        int h = num/100;
        if (h != 0) sb.append(arrayUnder20[h] + " Hundred");
        
        //The reason of trim here is because you don't know whether you add Hundred before or not
        int remainder = num % 100;
        if (remainder < 20) {
            sb.append(" " + arrayUnder20[remainder]);
            return sb.toString().trim();
        }        
        int u = remainder % 10;
        int t = remainder / 10;
        sb.append(" " + tens[t] + " " + arrayUnder20[u]);
        return sb.toString().trim();
    } 
}