//The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
//from unsorted part and putting it at the beginning.
public class selection_sort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2,7,9,0,5};
        selection_sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void selection_sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < minValue) {
                    minIndex = j;
                    minValue = nums[j];
                }
            }
            swap(nums, i, minIndex);
        }
    }

    public static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}