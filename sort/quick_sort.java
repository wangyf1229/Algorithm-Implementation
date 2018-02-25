class quick_sort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2,7,9,0,5};
        quick_sort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    public static void quick_sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pivot = nums[end];
        int left = start;
        int right = end;
        while (left <= right) {
            while (right >= left && nums[left] < pivot) {
                left++;
            }
            while (right >= left && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
               swap(nums, left, right);
               left++;
               right--;
            }
        }
        quick_sort(nums, start, right);
        quick_sort(nums, right + 1, end);
    }

    public static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}