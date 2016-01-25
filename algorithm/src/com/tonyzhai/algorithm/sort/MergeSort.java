package com.tonyzhai.algorithm.sort;

/**
 * 该算法完全按照算法导论伪代码实现，只是为了按照文章思路来讲解，并不是空间最优的解决思路，因为每次地柜都要创建两个数组
 * 
 * @author Administrator
 */
public class MergeSort {
	
	public static void mergeSort(int[] array){
		//执行初始调用MERGE-SORT(A, 1, A.length), Java数组下标从0开始，所以首位都 -1
		mergeSort(array, 0, array.length - 1);
	}
	
	private static void mergeSort(int[] array, int p, int r){
		if(p < r){
			//计算中间位置
			int q = (p + r) / 2;
			//递归分解过程直到为一个元素
			mergeSort(array, p, q);
			//递归分解过程直到为一个元素
			mergeSort(array, q + 1, r);
			//递归合并
			merge(array, p, q, r);
		}
	}
	
	private static void merge(int[] array, int p, int q, int r){
		//计算L即坐数组长度
		int n1 = q - p + 1;
		//计算R即有数组长度
		int n2 = r - q;
		//实例化左数组使其长度+1，以便放入哨兵元素
		int[] leftArray = new int[n1 + 1];
		//实例化右数组使其长度+1，以便放入哨兵元素
		int[] rightArray = new int[n2 + 1];
		int i = p;
		int k = 0;
		//将A[p.. q]复制到左数组
		while(i <= q){
			leftArray[k++] = array[i++];
		}
		int j = q + 1;
		k = 0;
		//将A[q + 1.. r]复制到右数组
		while(j <= r){
			rightArray[k++] = array[j++];
		}
		//放入哨兵元素
		leftArray[leftArray.length - 1] = Integer.MAX_VALUE;
		rightArray[rightArray.length - 1] = Integer.MAX_VALUE;
		i = 0;
		j = 0;
		k = p;
		//将两个数组依次比较最小元素放入输出堆即复制回原数组
		while(k <= r){
			if(leftArray[i] <= rightArray[j]){
				array[k++] = leftArray[i++];
			}else{
				array[k++] = rightArray[j++];
			}
		}
	}
	
	public static void main(String[] args){
		int[] array = {23, 1, 19, 100, 10};
		mergeSort(array);
		for(int i : array){
			System.out.print(i + " ");
		}
	}
}
