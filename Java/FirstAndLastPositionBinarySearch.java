public class FirstAndLastPositionBinarySearch {

    public int[] searchRange(int[] nums, int target) {
        final int first = searchFirstOrLastOfK(nums, target, 0, true);
        if (first == -1) {
            return new int[] { -1, -1 };
        }
        final int last = searchFirstOrLastOfK(nums, target, first, false);
        return new int[] { first, last };
    }

    public int searchFirstOrLastOfK(int[] nums, int k, int low, boolean first) {
        int high = nums.length - 1, ans = -1;
        while (low <= high) {
            final int mid = (low + high) >>> 1;
            if (nums[mid] < k) {
                low = mid + 1;
            } else if (nums[mid] == k) {
                if (first) { high = mid - 1; } else { low = mid + 1; }
                ans = mid;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
