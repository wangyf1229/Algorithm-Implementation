class merge_sort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2,7,9,0,5};
        merge_sort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void merge_sort(int[] nums, int start, int end) {
        if (start >= end) return;
        merge_sort(nums, start, (start + end)/2);
        merge_sort(nums, (start + end)/2 + 1, end);
        merge(nums, start, (start + end)/2, end);
    }

    public static void merge(int[] nums, int start, int mid, int end) {
        int[] new_Array = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                new_Array[k++] = nums[i++];
            } else {
                new_Array[k++] = nums[j++];
            }
        }

        while (k <= end - start) {
            if (j > end) {
            new_Array[k++] = nums[i++];
            } else {
                new_Array[k++] = nums[j++];
            }
        }


        int n = start;
        for (int m = 0; m < end - start + 1; m++) {
            nums[n++] = new_Array[m];
        }
    }


    public static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}