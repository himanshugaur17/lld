import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.BiFunction;

public class App {
    public static void main(String[] args) throws Exception {

    }
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int count = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == k)
                count++;
            mp.computeIfAbsent(sum, (key) -> 0);
            mp.put(sum, mp.get(sum) + 1);
            int sumCheck = sum - k;
            count += mp.getOrDefault(sumCheck, 0);
            mp.compute(sum, new BiFunction<Integer, Integer, Integer>() {

                @Override
                public Integer apply(Integer t, Integer u) {
                    // TODO Auto-generated method stub
                    return 1;
                }

            });
        }
        k = 0;
        return count;
    }
}
