package com.tonyzhai.algorithm.sort;

public class ShellSort {
    public static void sort(int[] array) {
        int out, in, tmp;
        int len = array.length;
        int h = 1;
        while(h < len / 3) // 计算间隔h最大值
            h = h * 3 + 1;

        while(h > 0){ // 能否继续通过缩小间隔h来分割数据列的判定
            /*
             * out为什么从h开始？你分割后的第一子序列应该是这样一个序列，0, h, 2h, 3h, ...
             * 插入排序的while循环是从1开始的，因为第一个数始终有序，不需要比较，这个需要了解插入排序的算法，所以比较是从第二个数据线，就是数组的第h个下标开始
             * out的判定为什么是out < len？
             * 控制数组下标，下面的例子会说道
             *
             * 下面举一个例子来解释
             * 假定有一个10个数据项的数组，数组下标从0 ~ 9 表示
             * 当h = 4时的子序列情况是这样的，以下标表示
             * （0 4 8）（1 5 9）（2 6）（3 7）
             * 我第一次是这么理解的，真对每一组分别进行插入排序（当然也可以这样实现，但是下标不好控制），但是对下面的代码来说这是错误的理解。
             * 正确的过程是这样的，外层for循环每次对每一分组的前两个数据项进行插入排序，然后前3个，然后前4个 ... 这个和子序列个数有关
             * 排序过程只真对方括号进行
             * 当out = 4时进行如下过程 （[0 4] 8）
             * 当out = 5时（[1 5] 9）
             * 当out = 6时（[2 6]）
             * 当out = 7时（[3 7]）
             * 当out = 8时（[0 4 8]）
             * 当out = 9时（[1 5 9]）
             * h = 4执行完毕，然后h = (h - 1) / 3 = 1开始新的for循环
             * h = 1时执行过程和h = 4时一样，不过这时的子数列就是原始的数列，蜕变为一个简单的插入排序，这是数组基本有序，数据项移动次数会大大减少
             *
             */
            for(out = h; out < len; out++){ // 外层通过out确定每组插入排序的第二个数据项
                // 以下代码就是对子序列进行的插入排序算法
                tmp = array[out];
                in = out;
                /*
                 * 比较插入排序while循环的写法，这里的while循环与h有关，所以判定就与h有关，包括 in -= h语句
                 * while(in > 0 && array[in - 1] > tmp){
                 * array[in] = array[in - 1];
                 * in--;
                 * }
                 * array[in] = tmp;
                 *
                 */
                while(in > h -1 && array[in - h] >= tmp){
                    array[in] = array[in - h];
                    in -= h;
                }
                array[in] = tmp;
//              for(int i = 0; i < len; i++)
//                  System.out.print(array[i] + " ");
//              System.out.println();

            }

            // 缩小间隔
            h = (h - 1) / 3;
        }
    }
}