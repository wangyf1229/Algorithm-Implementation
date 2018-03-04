public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public class Pair {
        public int sum;
        public int index;
        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
    public int[] subarraySumClosest(int[] nums) {
        if (nums.length == 0 || nums == null) return null;
        ArrayList<Pair> list = new ArrayList<>();
        int sum = 0;
        list.add(new Pair(0,-1));
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            list.add(new Pair(sum,i));
        }
        Collections.sort(list, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.sum - p2.sum;
            }
        });
        int[] result = new int[2];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list.size() - 1; i++) {
            int gap = Math.abs(list.get(i + 1).sum - list.get(i).sum);
            if (gap < min) {
                result[0] = list.get(i).index;
                result[1] = list.get(i+1).index;
                min = gap;
            }
        }
        if (result[0] > result[1]) {
            int temp = result[0];
            result[0] = result[1] + 1;
            result[1] = temp;
        } else if (result[0] < result[1]) {
            result[0] = result[0] + 1;
        }
        return result;
    }
}
