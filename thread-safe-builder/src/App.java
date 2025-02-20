import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            if (dq.isEmpty())
                dq.add(i);
            else {
                while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                    dq.pollLast();
                    dq.add(i);
            }
        }
        for (int we = k - 1; we < n; we++) {
            while (!dq.isEmpty() && dq.peekFirst() < we - k - 1)
                dq.pollFirst();
            res[we - (k - 1)] = nums[dq.peekFirst()];
            if (we <= n - 2) {
                while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[we + 1])
                    dq.pollLast();
                    dq.add(i);
            }

        }
        return res;
    }
}
