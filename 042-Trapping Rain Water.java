class Solution {
    public int trap(int[] height) {
        //monotone decreasing stack
        if (height == null || height.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int ptr = 0;
        int water = 0;
        while (ptr < height.length) {
            if (stack.isEmpty() || height[ptr] <= height[stack.peek()]) {
                stack.push(ptr);
                ptr++;
            } else {
                int baseIdx = stack.pop();
                if (stack.isEmpty()) continue;
                int leftL = stack.peek();
                int curWater = (ptr - leftL - 1) * (Math.min(height[leftL], height[ptr]) - height[baseIdx]);
                water += curWater;
            }
        }
        return water;
    }
}

class Solution {
    public int trap(int[] height) {
        //dp
        if (height == null || height.length == 0) return 0;
        int[] maxL = new int[height.length]; //the highest length from left not containing current bin
        int[] maxR = new int[height.length]; //the highest length from right not containing current bin
        maxL[0] = 0;
        maxR[height.length - 1] = 0;
        for (int i = 1; i < height.length; i++) {
            maxL[i] = Math.max(maxL[i - 1], height[i - 1]);
        }
        
        for (int i = height.length - 2; i >= 0; i--) {
            maxR[i] = Math.max(maxR[i + 1],height[i + 1]);
        }
        
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            int curWater = Math.max(Math.min(maxL[i], maxR[i]) - height[i], 0);
            water += curWater;
        }  
        return water;
    }
}

class Solution {
    public int trap(int[] height) {
        //Two Pointer
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}