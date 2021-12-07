package com.springboottemplate.Sort;

import java.util.Arrays;

import org.junit.Test;
/*
 *
 * 时间复杂度为log2^N。由于辅助空间是常数级别的所以：
空间复杂度是O(1);
*
*
* 问题：
最近有好几学生问我，无论是计算机算法概论、还是数据结构书中，

关于算法的时间复杂度很多都用包含O(logN)这样的描述，但是却没有明确说logN的底数究竟是多少。


解答：
算法中log级别的时间复杂度都是由于使用了分治思想,这个底数直接由分治的复杂度决定。
如果采用二分法,那么就会以2为底数,三分法就会以3为底数,其他亦然。
不过无论底数是什么,log级别的渐进意义是一样的。
也就是说该算法的时间复杂度的增长与处理数据多少的增长的关系是一样的。

我们先考虑O(logx(n))和O(logy(n))，x!=y，我们是在考虑n趋于无穷的情况。
求当n趋于无穷大时logx(n)/logy(n)的极限可以发现，极限等于lny/lnx，也就是一个常数，
也就是说，在n趋于无穷大的时候，这两个东西仅差一个常数。
所以从研究算法的角度log的底数不重要。，一般底数越大，图像上升趋势越慢，也就是坡度越低
*
 */

public class TestTwoPointsSearch {

	public static void main(String[] args) {

	}

	@Test
	public void test() {
		/*
		 * 联系二分查找以及冒泡排序
		 */
		int[] arr = { 9, 8, 6, 4, 9, 8, 7, 2, 2, 3, 4, 1, 0, 6, 5 };
		int[] arr2 = { 9, 8, 7, 6, 5 };
		// Arrays.sort(arr);//别人提供的排序方法
		// 我们使用冒泡排序手动排序

		for (int i = 0; i < arr.length - 1; i++) {// 第一次排序
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));// [0, 1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8, 9, 9]
		// 上面排序完成，开始二分查找一个元素
		int target = 8;// 查询目标是5
		int left = 0;
		int right = arr.length - 1;
		//int mid = right / 2;//写在这里是错的，因为mid是动的。
		while (left <=right) {
			int mid=(left+right)/2;
			if (arr[mid] == target) {
				System.out.println("存在目標數字：" + target + "---这个数字数组下表为：" + mid + "---值为:" + arr[mid]);
				return;// break指的是跳出whlie循环，return，是后面代码都不执行了
			}else if (target > arr[mid]) {// 如果目标比mid小，说明在左边
				left = mid + 1;

			} else {
				right = mid - 1;
			}

		}
		System.out.println("不存在数字" + target);

	}

}
