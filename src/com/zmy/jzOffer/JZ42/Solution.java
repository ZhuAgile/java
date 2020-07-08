package com.zmy.jzOffer.JZ42;

import javax.xml.soap.Node;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.jzOffer.JZ42
 * @projectName : project01
 * @date : 2020-06-16 18:31
 *
 * @description :
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 * 本题知识点：数组、数学、双链表
 *
 * 解题思路：
 *    [1,2,2,3,4,5,7,8,10]
 *    因为是递增排序数组，因此
 **/
public class Solution {


    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {

        ArrayList<Integer> list = new ArrayList<>();
        // 如果数组长度为空或者为1，则不能满足条件的要求
        if(array == null || array.length < 2) {
            return list;
        }

        int begin = 0;
        int end = array.length-1;

        while(begin < end){
            if (array[begin] + array[end] == sum) {
                list.add(array[begin]);
                list.add(array[end]);
                return list;
            }else if (array[begin] + array[end] < sum) {
                    begin++;
            }else{
                end--;
            }

        }

        return list;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,3,3,5,6};
        int target = 4;
        solution.FindNumbersWithSum(arr,target);
    }
}
