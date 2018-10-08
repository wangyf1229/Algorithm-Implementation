class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if ((len1 + len2) % 2 == 1) {
            return helper(nums1, nums2, 0, 0, (len1+len2)/2 + 1);
        } else {
            int num1 = helper(nums1, nums2, 0, 0, (len1+len2)/2);
            int num2 = helper(nums1, nums2, 0, 0, (len1+len2)/2 + 1);
            //the median may be a double, like 3.5 or 4.5
            return (num1 + num2)/2.0;
        }
    }
    
    public int helper(int[] nums1, int[] nums2, int start1, int start2, int k) {
        //The idea is that for each recursion, I compare the k/2 elements from nums1 and nums2
        //and remove k/2 elements from our consideration.
        
        //base case
        if (start1 >= nums1.length) return nums2[k + start2 - 1];
        if (start2 >= nums2.length) return nums1[k + start1 - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        
        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MAX_VALUE;
        //if the length of arrray is smaller than start + k/2, we will do nothing to this array 
        //and remove the k/2 elements from another array;
        if (start1 + k/2 - 1 < nums1.length) m1 = nums1[start1 + k/2 - 1];
        if (start2 + k/2 - 1 < nums2.length) m2 = nums2[start2 + k/2 - 1];
        if (m1 < m2) {
            //if m1 < m2, start1 + k/2 <= nums1.length. 
            //So we don't need to worry that the index of nums1 exceed the length of nums1.
            //k - k/2 is in order to avoid the occasion that k is odd.
            //If k == 2, k - k/2 = k/2 = 1;
            //If k == 3, k - k/2 = 2;
            return helper(nums1, nums2, start1 + k/2, start2, k - k/2);
        } else {
            return helper(nums1, nums2, start1, start2 + k/2, k - k/2);
        }
    }
}