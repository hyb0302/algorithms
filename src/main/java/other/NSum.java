package other;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author huangyb
 * @date 2020/7/17
 */
public class NSum {

    public static List<List<Integer>> NSumTarget(List<Integer> nums, int start, int target, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || nums.size() < n) {
            return res;
        }
        if (start >= nums.size()) {
            return res;
        }

        if (n == 2) {
            int left = start;
            int right = nums.size() - 1;

            while (left < right) {
                int sum = nums.get(left) + nums.get(right);
                int leftVal = nums.get(left);
                int rightVal = nums.get(right);
                if (sum > target) {
                    while (left < right && nums.get(right) == rightVal) {
                        right--;
                    }
                } else if (sum < target) {
                    while (left < right && nums.get(left) == leftVal) {
                        left++;
                    }
                } else if (sum == target) {
                    res.add(Arrays.asList(nums.get(left), nums.get(right)));
                    while (left < right && nums.get(right) == rightVal) {
                        right--;
                    }
                    while (left < right && nums.get(left) == leftVal) {
                        left++;
                    }
                }
            }
        } else {
            for (int i = start; i < nums.size(); i++) {
                List<List<Integer>> lists = NSumTarget(nums, i + 1, target - nums.get(i), n - 1);
                for (List<Integer> integers : lists) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums.get(i));
                    l.addAll(integers);
                    res.add(l);
                }
                while (i < nums.size() - 1 && nums.get(i).equals(nums.get(i + 1))) {
                    i++;
                }
            }
        }

        return res;
    }

    public static List<List<Integer>> twoSum(List<Integer> nums, int target) {
        Collections.sort(nums);
        System.out.println(nums);
        return NSumTarget(nums, 0, target, 3);
    }

    public static void main(String[] args) {
        System.out.println(twoSum(Arrays.asList(1, 3, 1, 2, 2, 3, 6, 3, 0), 6));
    }
}
