package com.zmy.algorithms.sort.simpleSort.bubbleSort;

/**
 * 冒泡排序
 *   数据按照一定的规则，小的数据浮上来，大的数据沉下去
 *   实现：
 *      假设最后一位是最小的数，则最后一位数逐级与前面的数进行比较。最后，最小的数变成第一位
 *      完成后，继续从最后一位开始，找到第二小的数据，依次类推，直到将所有的数据排完序。
 */
public class BubbleSortTest {

    // 冒泡排序方法实现
    public void bubbleSort(long[] arr){
        int i,j;
        long temp;
        for (i = arr.length - 1; i>=0; i--) {
            for (j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public void display(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +", ");
        }
    }

    public static void main(String[] args) {
        BubbleSortTest bst = new BubbleSortTest();
        long[] arr = new long[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (long)(Math.random()*100);
        }

        bst.display(arr);

        bst.bubbleSort(arr);
        System.out.println();

        bst.display(arr);
    }
}
