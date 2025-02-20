import java.util.ArrayList;
import java.util.List;

public class RunLengthEncodingProduct {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0, j = 0;
        int n = encoded1.length, m = encoded2.length;
        while (i < n && j < m) {
            int product = encoded1[i][0] * encoded2[j][0];
            int cnt1 = encoded1[i][1], cnt2 = encoded2[j][1];
            int resCnt = Math.min(cnt1, cnt2);
            if (result.isEmpty() || result.get(result.size() - 1).get(0) != product)
                result.add(List.of(product, resCnt));
            else
                result.get(result.size() - 1).set(1, result.get(result.size() - 1).get(1) + resCnt);
            encoded1[i][1] -= resCnt;
            encoded2[j][1] -= resCnt;
            if (encoded1[i][0] == 0)
                i++;
            if (encoded2[j][1] == 0)
                j++;
        }
        return result;
    }
}

class Solution {
    private int travel(char[] wS, char prev, int n, int k, String res, int index, int count, StringBuilder sb) {
        if (index == n) {
            count++;
            if (count == k) {
                res = sb.toString();
                return k;
            }
            return count;
        }
        int length = sb.length()-1;
        for (int i = 0; i < 3 && count < k; i++) {
            if (wS[i] != prev) {
                sb.append(wS);
                count = travel(wS, wS[i], n, k, res, index + 1, count, sb);
                sb.setLength(length);
            }
        }
        
        return count;
    }

    public String getHappyString(int n, int k) {
        String res = "";
        char[] wS = new char[] { 'a', 'b', 'c' };
        StringBuilder sb = new StringBuilder();
        travel(wS, 'd', n, k, res, 0, 0, sb);
        return res;
    }
}
