package com.zmy.jzOffer.JZ7;

/**
 * @author : Agile Zhu
 * @packageName : com.zmy.jzOffer.JZ7
 * @projectName : project01
 * @date : 2020-06-17 10:54
 *
 * @description :
 *  题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 *
 * 本题知识点： 递归
 **/
public class Solution {

    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if( n > 1) return Fibonacci(n - 1) + Fibonacci(n -2);

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Fibonacci(39));
    }
}
