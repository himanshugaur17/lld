package jvm.memory.shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int rightMax = Integer.MAX_VALUE, leftMin = Integer.MIN_VALUE;
        int leftIndex = n, rightIndex = n;
        for (int i = 0; i < n; i++) {
            if (nums[i] < leftMin) {
                leftIndex = i - 1;
                break;
            }
            leftMin = nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > rightMax) {
                rightIndex = i + 1;
                break;
            }
            rightMax = nums[i];
        }
        if (leftIndex == n)
            return 0;
        else if (leftIndex == 0)
            return n;
        else
            return rightIndex - leftIndex + 1;
    }
}
