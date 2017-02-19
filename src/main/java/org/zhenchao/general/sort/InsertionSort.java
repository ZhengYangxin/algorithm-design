package org.zhenchao.general.sort;

/**
 * 插入排序
 *
 * @author zhenchao.wang 2017-02-19 16:41
 * @version 1.0.0
 */
public class InsertionSort extends AbstractSortAlgorithm<Integer> {

    @Override
    public void sort(Integer[] a) {
        for (int i = 1; i < a.length; i++) {
            // 向前寻找插入位置，所有比当前元素大的元素均需要往后站
            for (int j = i; j > 0 && this.less(a[j], a[j - 1]); j--) {
                this.exch(a, j, j - 1);
            }
        }
    }

}
