public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numbers == null && numbers.length < 4) return result;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i-1]) continue;
            result = threeSum(i+1, numbers[i], target, numbers, result);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> threeSum(int start, int num1, int target, int[] numbers, ArrayList<ArrayList<Integer>> result){
        for (int i = start; i < numbers.length; i++) {
            if (i > start && numbers[i] == numbers[i-1]) continue;
            result = twoSum(i+1, num1, numbers[i], target, numbers, result);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> twoSum(int start, int num1, int num2, int target, int[] numbers, ArrayList<ArrayList<Integer>> result){
        int left = start;
        int right = numbers.length - 1;
        int targetNow = target - num1 - num2;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < targetNow) {
                left++;
            }else if (sum > targetNow) {
                right--;
            }else if (sum == targetNow) {
                ArrayList<Integer> resultTmp = new ArrayList<Integer>();
                resultTmp.add(num1);
                resultTmp.add(num2);
                resultTmp.add(numbers[left]);
                resultTmp.add(numbers[right]);
                result.add(resultTmp);
                left++;
                right--;
                while (left < right && numbers[left] == numbers[left-1]) {
                    left++;
                }
                while (left < right && numbers[right] == numbers[right+1]) {
                    right--;
                }
            }
        }
        return result;
    }
}