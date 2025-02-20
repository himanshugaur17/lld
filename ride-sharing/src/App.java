public class App {
    public static void main(String[] args) throws Exception {
        new Solution().getHappyString(3, 9);
    }
}

/*
 * RIDER UBER DRIVER
 * from, to
 * driverMatching
 * no 2 drivers accept same ride req
 * |-------|
 * | ***** |
 * | from |
 * | |
 * |-------|
 *
 */

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = nums[i].charAt(i);
            sb.append(c == '1' ? '0' : '1');
        }
        return sb.toString();
    }
}