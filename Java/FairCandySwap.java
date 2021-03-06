import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class FairCandySwap {

    public static void main(String[] args) {
        final int[] a = { 21, 89, 90, 88, 54, 45, 67, 41, 57, 7 };
        final int[] b = { 55, 57, 22, 19, 44, 91, 100, 71, 33, 33 };
        System.out.println(Arrays.toString(fairCandySwap(a, b)));
        System.out.println(Arrays.toString(fairCandySwap2(a, b)));
    }

    public static int[] fairCandySwap(int[] a, int[] b) {
        int diff = 0;
        for (int i : a) { diff += i; }
        for (int i : b) { diff -= i; }

        final int[] res = new int[2];

        for (int i : a) {
            for (int j : b) {
                if (2 * (i - j) == diff) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }

        return res;
    }

    public static int[] fairCandySwap2(int[] a, int[] b) {
        int diff = 0;
        final Set<Integer> set = new HashSet<>();
        for (int i : a) {
            diff += i;
            set.add(i);
        }
        for (int i : b) {
            diff -= i;
        }
        diff /= 2;
        for (int i : b) {
            if (set.remove(i + diff)) { return new int[] { i + diff, i }; }
        }
        return new int[0];
    }

    private FairCandySwap() {}
}
