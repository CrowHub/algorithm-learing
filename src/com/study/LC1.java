package com.study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC1 {
    public static void main(String[] args) {

        LC1 lc1 = new LC1();
        System.out.println(Arrays.toString(lc1.twoSum01(new int[]{2, 7, 11, 15}, 22)));
        System.out.println(Arrays.toString(lc1.twoSum01(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(lc1.twoSum01(new int[]{3, 3}, 6)));

    }

    /**
     * o(n*n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 哈希表
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum01(int[] nums, int target) {
        Map<Integer, Integer> posMap = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (posMap.containsKey(target - nums[i])) {
                return new int[]{posMap.get(target - nums[i]), i};
            }
            posMap.put(nums[i], i);
        }
        return new int[0];
    }
}
