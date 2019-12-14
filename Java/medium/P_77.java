package medium;

import java.util.ArrayList;
import java.util.List;

public final class P_77 {

    public static List<List<Integer>> combine(int n, int k) {
        final List<List<Integer>> res = new ArrayList<>();
        recurse(1, n, k, new ArrayList<>(), res);
        return res;
    }

    public static void recurse(int start, int n, int k, List<Integer> curr, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            curr.add(i);
            recurse(i + 1, n, k - 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(3, 3));
    }

    private P_77() {}
}
