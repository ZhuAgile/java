package com.zmy.leetcode.lc148;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.leetcode.lc148
 * @projectName : project01
 * @date : 2020-06-15 23:31
 *
 * @description :
 * 题目描述
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 * 假设给出的数组中只存在唯一解
 * 例如：
 *
 * 给出的数组为 {2, 7, 11, 15},目标值为9
 * 输出 ndex1=1, index2=2
 *
 * 示例1
 *
 * 输入
 * [3,2,4],6
 *
 * 输出
 * [2,3]
 **/
public class Solution {

    public int[] twoSum(int[] numbers,int target){
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3,5,2,4};
        int target = 7;
        solution.twoSum(arr,target);

    }
}
