public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        //Solution 1: Hash Table
        int[] result = new int[2];
        if (numbers == null || numbers.length == 0) return result;
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            if (hashmap.get(target - numbers[i]) != null) {
                result[1] = i + 1;
                result[0] = hashmap.get(target-numbers[i]) + 1;
                return result;
            }
            hashmap.put(numbers[i],i);
        }
        return result;

        //Solution 2: Two pointers
        //have some problems (there shouldn't be any duplicates in the numbers array.)
        // int[] result = new int[2];
        // if (numbers == null || numbers.length == 0) return result;
        // HashMap<Integer,Integer> hashmap = new HashMap<Integer, Integer>();
        // for (int i = 0; i < numbers.length; i++) {
        //     hashmap.put(numbers[i],i);
        // }
        // Arrays.sort(numbers);
        // int first = 0;
        // int last = numbers.length - 1;
        // while (numbers[first] + numbers[last] != target && first + 1 < last) {
        //     if (numbers[first] + numbers[last] < target) {
        //         first ++;
        //     } else {
        //         last --;
        //     }
        // }
        // if (numbers[first] + numbers[last] == target) {
        //     result[0] = hashmap.get(numbers[first]) + 1;
        //     result[1] = hashmap.get(numbers[last]) + 1;
        //     if(result[0] > result[1]) {
        //         int temp = result[0];
        //         result[0] = result[1];
        //         result[1] = temp;
        //     }
        // }
        // return result;
    }
}