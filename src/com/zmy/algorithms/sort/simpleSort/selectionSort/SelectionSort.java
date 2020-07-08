package com.zmy.algorithms.sort.simpleSort.selectionSort;

/**
 *  选择排序
 *    选择排序是默认标记首位数据为最小数据，然后依次与其他数据进行比较，当发现比默认数据小，
 *    则将当前数据标记为最小数据，直到遍历完所有数据并直到最小数据。最后，将最小数据与本次
 *    遍历集合中的首位集合交换
 */
public class SelectionSort {

    private long[] arr = new long[10];

    /*
     * 数组中添加元素
     */
    public void insert () {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (long)(Math.random()*10);
        }
    }

    /*
     * 展示数组中的元素
     */
    public void display() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.print("\r\n");
    }

    /*
     * 选择排序
     */
    public void selectionSort(long[] arr) {
        long temp;
        int minValue = 0;
        for (int i = 0; i < arr.length; i++) {
            minValue = i;
            for (int j = i;j < arr.length - 1; j++) {
               if (arr[minValue] > arr[j+1]) {
                   minValue = j + 1;
               }
            }

            // 将每次循环查找到的最小数值放到本次循环的首位
            temp = arr[minValue];
            arr[minValue] = arr[i];
            arr[i] = temp;

            // 测试查询每次查询后并交换的结果
            System.out.println("第"+i+"次排序的结果：");
            for (int a = 0; a < arr.length; a++) {
                System.out.print(arr[a] + " ");
            }

        }
    }

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        ss.insert();
        ss.display();

        ss.selectionSort(ss.arr);

        System.out.println();
        ss.display();

    }

}
