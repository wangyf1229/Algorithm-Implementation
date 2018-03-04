class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     *
     */
    public void sortColors2(int[] colors, int k) {
        //Solution 1: Counting sort;
        if (colors == null || colors.length == 0) return;
        int[] num = new int[k + 1];
        for (int i = 0; i < colors.length; i++) {
            num[colors[i]]++;
        }
        int index = 0;
        for (int i = 1; i < k + 1; i++) {
            for (int j = index; j < index + num[i]; j++) {
                colors[j] = i;
            }
            index = index + num[i];
        }
    }
}