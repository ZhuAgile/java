package com.zmy.algorithms.sort.simpleSort.insertSort;

/**
 * 插入排序
 *   插入排序的含义是序列中有一个界标，界标左边都是排好序的，右边都是暂未排好序的。
 *   现在界标会逐渐向右移动，被界标标识的数据就要在界标左边找到合适的位置插入。
 *    依次类推，直到所有的数据都插入到正确的位置上
 *
 */
public class InsertSort {
    private long[] arr;

    /*
     * 初始化序列长度
     */
    InsertSort(int length) {
        this.arr = new long[length];
    }

    /*
     * 序列中添加元素
     */
    public void insert() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (long) (Math.random()*20);
        }
    }

    /*
     * 序列中元素展示
     */
    public void display() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /*
     * 插入排序方法实现
     */
    public void insertSort() {
        int out; // 界标
        int in; // 元素应该插入的位置

        for (out = 1; out < arr.length; out++) { // 遍历并获取界标右侧元素
            long temp = arr[out];
            // 将获取到的界标元素插入界标左侧的合适位置
            in = out;
            while (in > 0 && arr[in-1] >= temp) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = temp;
        }
    }

    public static void main(String[] args) {
        InsertSort is = new InsertSort(10);
        is.insert();
        is.display();

        is.insertSort();

        System.out.println();
        is.display();
    }

}
