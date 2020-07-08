package com.zmy.algorithms.sort.recursion;

import java.util.zip.Adler32;

/**
 * 归并排序
 *   归并算法的中心是归并两个已经有序的数组。归并两个有序数组A和B，就生成了第三个数组C，数组C包含数组
 *   A和B的所有数据项，并且使它们有序的排列在数组C中。
 *
 *   The heart of the mergesort algorithm is the merging of two already-sorted arrays.
 *   Merging two sorted arrays A and B creates a third array,C,that contains all the
 *   elements of A and B,also arranged in sorted order.
 */
public class MergeSort {
    /*
     * 归并排序
     */
    public void mergeSort(int[] arrA, int[] arrB,int[] arrC){
        int ADex = 0,BDex = 0,CDex = 0;

        while(ADex < arrA.length && BDex < arrB.length){
            // 如果序列A中当前元素比序列B中当前元素小，则序列A中的当前元素进入序列C中
            if (arrA[ADex] < arrB[BDex]) {
                arrC[CDex] = arrA[ADex];
                ADex++;
                CDex++;
            }else{
                arrC[CDex] = arrB[BDex];
                BDex++;
                CDex++;
            }
        }

        // 当序列B中的元素已经全部进入到序列C中,则序列A中的剩下的所有元素直接进入到序列C中
        while (ADex < arrA.length) {
            arrC[CDex] = arrA[ADex];
            CDex++;
            ADex++;
        }

        // 当序列A中的元素已经全部进入到序列C中,则序列B中的剩下的所有元素直接进入到序列C中
        while(BDex < arrB.length) {
            arrC[CDex] = arrB[BDex];
            CDex++;
            ADex++;
        }

    }

    public void display(int[] arrC) {
        for (int i = 0; i < arrC.length; i++) {
            System.out.print(arrC[i] + " ");
        }
    }


    public static void main(String[] args) {
        int[] arrA = {23,47,81,95};
        int[] arrB = {7,14,39,55,62,74};
        int[] arrC = new int[arrA.length + arrB.length];

        MergeSort ms = new MergeSort();
        ms.mergeSort(arrA,arrB,arrC);
        ms.display(arrC);


    }

}
