package sort.merge;

import sort.Sort ;

/**
 * 归并排序
 * @author 七夜雪
 *
 */
public class MergeSort implements Sort {
	
	@Override
	public void sort(int [] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}
	
	/**
	 * 对数组arr的[l, r]的区间进行排序
	 * @param arr
	 * @param l
	 * @param r
	 */
	private void mergeSort(int[] arr, int l, int r){
		// 递归终止条件
		if (l >= r) {
			return;
		}
		
		int mid = l + (r - l) / 2;
		// 对[l, mid]部分进行归并排序
		mergeSort(arr, l, mid);
		// 对[mid + 1, r]进行归并排序
		mergeSort(arr, mid + 1, r);
		// 对[l, mid], [mid + 1, r]这两部分进行归并
		merge(arr, l, mid, r);
	}
	
	
	/**
	 * 对数组[l, mid], [mid + 1, r]这两部分进行归并
	 * @param arr
	 * @param l
	 * @param mid
	 * @param r
	 */
	private void merge(int[] arr, int l, int mid, int r){
		// 用于归并排序的辅助空间, 因为[l, r]是前闭后闭的区间, 所以aux的大小是r - l + 1
		int[] aux = new int[r - l + 1];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = arr[i + l];
		}
		
//		for (int i = l; i <= r; i++) {
//			aux[i - l] = arr[i];
//		}
		
		// 用于记录左半部分数组下标
		int leftIndex = l;
		// 用于记录右半部分数组下标
		int rightIndex = mid + 1;
		// 循环进行归并
		for (int k = l; k <= r; k++) {
			// 表示左侧部分已经完成归并, 直接使用右侧部分进行归并
			if (leftIndex > mid) {
				arr[k] = aux[rightIndex - l];
				rightIndex++;
			// 表示右侧部分已经完成归并, 直接使用左侧部分进行归并
			} else if (rightIndex > r) {
				arr[k] = aux[leftIndex - l];
				leftIndex++;
			// 左侧元素小于右侧元素, 使用左边元素进行归并
			} else if (aux[leftIndex - l] < aux[rightIndex - l]) {
				arr[k] = aux[leftIndex - l];
				leftIndex++;
			} else {
				arr[k] = aux[rightIndex - l];
				rightIndex++;
			}
		}
	}
	
}
