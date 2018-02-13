class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] charArray = new int[256];
        for (int i = 0; i < s.length(); i++) {
            charArray[(int) s.charAt(i)]++;
        }
        int oddNumber = 0;
        for (int num : charArray) {
            if (num % 2 == 1) oddNumber++;
        }

        return (oddNumber <= 1);
    }
}