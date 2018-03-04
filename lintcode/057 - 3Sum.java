public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        //Solution 1: HashTable;
        // ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // if (numbers == null || numbers.length == 0) return result;
        // for (int i = 0; i < numbers.length; i++) {
        //     //Should use Set instead of List here!!!
        //     Set<Integer> hashset = new HashSet<>();
        //     if (i > 0 && numbers[i] == numbers[i-1]) continue;
        //     for (int j = i + 1; j < numbers.length; j++) {
        //         if (hashset.contains(-numbers[i]-numbers[j])) {
        //           ArrayList<Integer> resultTmp = new ArrayList<>();
        //           resultTmp.add(numbers[i]);
        //           resultTmp.add(-numbers[i]-numbers[j]);
        //           resultTmp.add(numbers[j]);
        //           Collections.sort(resultTmp);
        //           if (!(result.contains(resultTmp))){
        //                 result.add(resultTmp);
        //           }
        //         }
        //         hashset.add(numbers[j]);
        //     }
        // }
        // return result;

        //Solution 2: Sort + Two Pointers;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length == 0) return result;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) continue;
            result = TwoSum(i + 1, numbers.length - 1, -numbers[i], numbers, result);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> TwoSum(int left, int right, int target, int[] numbers, ArrayList<ArrayList<Integer>> result) {
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else if (sum == target) {
                ArrayList<Integer> resultTmp = new ArrayList<>();
                resultTmp.add(-target);
                resultTmp.add(numbers[left]);
                resultTmp.add(numbers[right]);
                if (!(result.contains(resultTmp))){
                    result.add(resultTmp);
                }
                left++;
                right--;
                while(left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                while(left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }
            }
        }
        return result;
    }
}