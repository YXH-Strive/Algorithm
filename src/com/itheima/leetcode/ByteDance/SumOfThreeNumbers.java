package com.itheima.leetcode.ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YXH
 * @date 2020/7/19 - 10:52
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class SumOfThreeNumbers {
    public static List<List<Integer>> threeSum(int[] nums) {
        //先给定的数组重排序
        Arrays.sort(nums);
        List<List<Integer>> allList = new ArrayList<List<Integer>>();
        //假设i为start指针与end指针的和
        for(int i = 0 ; i < nums.length - 2;){
            //start指针对应起始位置
            int start = i + 1;
            //end指针对应结束位置
            int end = nums.length - 1;
            while(start < end ){
                if(nums[start] + nums[end] == -nums[i]){
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    allList.add(list);
                    start++;
                    end--;
                    //除去end指针的重复值
                    while(nums[end] == nums[end+1] && start < end){
                        end--;
                    }
                    //除去start指针的重复值
                    while(nums[start] == nums[start-1] && start < end){
                        start++;
                    }
                }
                //3值的和大于0时，重新检测end指针是否重复后降值
                else if(nums[start] + nums[end] > -nums[i] ){
                    end--;
                    while(nums[end] == nums[end+1] && start < end){
                        end--;
                    }
                }
                //3值的和小于0时，重新检测start指针是否重复后升值
                else{
                    start++;
                    while(nums[start] == nums[start-1] && start < end){
                        start++;
                    }
                }
            }

            i++;
            while(nums[i] == nums[i-1] && i < nums.length - 2){
                i++;
            }
        }
        return allList;
    }
}
