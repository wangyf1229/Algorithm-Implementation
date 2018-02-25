class heap_sort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2,7,9,0,5};
        heap_sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void heap_sort(int[] nums) {
        int n = nums.length;
        for (int i = n/2 + 1; i >=0; i--) {
            heapify(nums, n, i);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i, 0);
        }
    }

    public static void heapify(int[] nums, int n, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, n, largest);
        }
    }


    public static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}