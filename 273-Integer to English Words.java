class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int count = 0;
        String[] countArray = new String[]{"", "Thousand", "Million", "Billion"};
        String res = new String();
        while( num > 0) {
            int remainder = num % 1000;
            String output = transferThreeNumbers(remainder);
            if (!output.equals("")) {
                res = output + " " + countArray[count] + " " + res;
            }
            num = num/1000;
            count++;
        }
        return res.trim();
    }
    
    public String transferThreeNumbers(int num) {
        String[] arrayUnder20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String first = num < 100 ? arrayUnder20[0] : arrayUnder20[num/100] + " Hundred";
        int remainder = num % 100;
        String secThird = "";
        if (remainder < 20) {
            secThird = arrayUnder20[remainder];
        } else {
            int unitsDigit = remainder % 10;
            int tensDigit = remainder / 10;
            secThird = tens[tensDigit] + " " + arrayUnder20[unitsDigit];
        }
        String result = first + " " + secThird;
        return result.trim();
    }
    
}