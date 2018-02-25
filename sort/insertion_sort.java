// Sort an arr[] of size n
// insertionSort(arr, n)
// Loop from i = 1 to n-1.
// ……a) Pick element arr[i] and insert it into sorted sequence arr[0…i-1]
public class insertion_sort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2,7,9,0,5};
        insertion_sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void insertion_sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
              int j = i + 1;
              int key = nums[j];
              while (j > 0 && nums[j - 1] > key) {
                nums[j] = nums[j - 1];
                j--;
              }
              nums[j] = key;
           }
    }

}