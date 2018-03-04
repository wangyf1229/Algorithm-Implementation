public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Solution 1: Using HashSet
        //if (nums1 == null || nums2 == null) return null;
        // HashSet<Integer> hashset = new HashSet<>();
        // HashSet<Integer> intersection = new HashSet<>();
        // for (int i = 0; i < nums1.length; i++){
        //     hashset.add(nums1[i]);
        // }
        // for (int i = 0; i < nums2.length; i++) {
        //     if(hashset.contains(nums2[i]) && !intersection.contains(nums2[i])) {
        //         intersection.add(nums2[i]);
        //     }
        // }
        // int[] result = new int[intersection.size()];
        // int j = 0;
        // for (int i: intersection) {
        //     result[j++] = i;
        // }
        // return result;

        //Solution 2: Sort and binary search
        if (nums1 == null || nums2 == null) return null;
        //if (nums1.length == 0 || nums2.length == 0) return new int[0];
        HashSet<Integer> intersection = new HashSet<>();
        Arrays.sort(nums1);
        for (int i = 0; i < nums2.length; i++) {
            if (binarySearch(nums1,nums2[i])) intersection.add(nums2[i]);
        }
        int[] result = new int[intersection.size()];
        int j = 0;
        for (int i: intersection) {
            result[j++] = i;
        }
        return result;

    }

    public boolean binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) return true;
            if (nums[mid] < target) {
                start = mid;
            }else {
                end = mid;
            }
        }
        if (nums[start] == target) return true;
        if (nums[end] == target) return true;
        return false;
    }

    //Solution 3: Sort and merge;
    //     if (nums1 == null || nums2 == null) return null;
    //     Arrays.sort(nums1);
    //     Arrays.sort(nums2);
    //     int[] result = new int[nums1.length];
    //     int index = 0, i = 0, j = 0;
    //     while (i < nums1.length && j < nums2.length) {
    //         if (nums1[i] == nums2[j]) {
    //             if (index == 0 || result[index - 1]!= nums1[i]) {
    //                 result[index++] = nums1[i];
    //             }
    //             i++;
    //             j++;
    //         }else if (nums1[i] < nums2[j]) {
    //             i++;
    //         }else if (nums1[i] > nums2[j]) {
    //             j++;
    //         }
    //     }
    //     int[] resultFinal = new int[index];
    //     for (i = 0; i < index; i++){
    //         resultFinal[i] = result[i];
    //     }
    //     return resultFinal;
    // }

}