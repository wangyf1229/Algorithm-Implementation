class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(); //nums1[i] => the times of the appearance of nums1[i]
        for (int i = 0; i < nums1.length; i++) {
            int time = map.getOrDefault(nums1[i], 0);
            map.put(nums1[i], time + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                int time = map.get(nums2[i]);
                res.add(nums2[i]);
                if (time == 1)  {
                    map.remove(nums2[i]);
                } else {
                    map.put(nums2[i], time - 1);
                }
            }
        }
        int[] resAry = new int[res.size()];
        for (int i = 0; i < resAry.length; i++) {
            resAry[i] = res.get(i);
        }
        return resAry;
    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //Follow up 1: What if the given array is already sorted? How would you optimize your algorithm?
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> resList = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] == nums2[j]) {
                resList.add(nums1[i]);
                i++;
                j++;
            } else {
                j++;
            }
        }
        int[] resAry = new int[resList.size()];
        for (int k = 0; k < resAry.length; k++) {
            resAry[k] = resList.get(k);
        }
        return resAry;
    }
}