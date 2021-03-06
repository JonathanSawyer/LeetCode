package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class P_40 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        final List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        recurse(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private static void recurse(int[] candidates,
                                int start,
                                int target,
                                List<Integer> curr,
                                List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) { continue; }
            curr.add(candidates[i]);
            recurse(candidates, i + 1, target - candidates[i], curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[] { 2, 3, 6, 7 }, 7));
        System.out.println(combinationSum2(new int[] { 2, 3, 5 }, 8));
        System.out.println(combinationSum2(new int[] { 8, 7, 4, 3 }, 11));
        System.out.println(combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
    }

    private P_40() {}
}
