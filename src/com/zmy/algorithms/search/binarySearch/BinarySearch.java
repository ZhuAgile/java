package com.zmy.algorithms.search.binarySearch;

/**
 * 二分查找
 *   二分查找的前提是数据有序排列，当要查寻一个数据searchValue是否存在时，先比较首位数据start和末位数据end中间位置
 *   middle的数据是否符合，如果，中间数据arr[middle]比要找的数据大，则目标数据应该在左侧，则首位数据仍为arr[start],
 *   末位数据为arr[middle - 1]继续从左侧中间位置
 *   进行数据查找，直到找到目标数据，则查询结束。
 *   当没有找到数据时，即start>end,则查询也结束并提示没有该数据。
 */
public class BinarySearch {
    // 定义容量为20的数组
    private long[] arr  = new long[20];
    int start = 0;
    int end = arr.length - 1;

    /*
     * 二分查询方法
     */
   /* public long find (long searchValue) {
        int start = 0;
        int end = arr.length - 1;

        // 循环查询
        while (true) {

            int middle = (start + end ) / 2;

            // 如果刚好在中间位置找到目标数据
            if (arr[middle] == searchValue) {
                System.out.println("目标数据已找到，当期位置在" + middle + ", 值为：" + arr[middle]);
                return arr[middle];
            }else if ( start > end) {
                System.out.println("目标数据不在该查询序列中！");
                break;
            }else {
                // 如果中间数据比目标数据大
                if (arr[middle] > searchValue) {
                    end = middle - 1;
                }

                // 如果中间数据比目标数据小
                if (arr[middle] < searchValue) {
                    start = middle + 1;
                }
            }
        }
          return 0L;
    }*/

        /*
         * 二分递归查找
         */
        public long find (long searchValue) {
            int middle = (start + end) / 2;
            // 找到了目标数据
            if (arr[middle] == searchValue) {
                System.out.println("目标数据已找到，当期位置在" + middle + ", 值为：" + arr[middle]);
                return arr[middle];
            }else if (start > end) {
                System.out.println("目标数据" + searchValue +"在数组中未找到！");
            }else {
                // 如果中间数据比目标数据大
                if (arr[middle] > searchValue) {
                    end = middle - 1;
                    this.find(searchValue);
                }

                // 如果中间数据比目标数据小
                if (arr[middle] < searchValue) {
                    start = middle + 1;
                    this.find(searchValue);
                }
            }

          return 0L;
        }

        public static void main(String[] args) {
            BinarySearch bs = new BinarySearch();

            for (int i = 0; i < 20; i++) {
                bs.arr[i] = 10 + i;
            }

            bs.find(-1L);

        }
}
