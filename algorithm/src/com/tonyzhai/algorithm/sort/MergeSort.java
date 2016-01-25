package com.tonyzhai.algorithm.sort;

/**
 * ���㷨��ȫ�����㷨����α����ʵ�֣�ֻ��Ϊ�˰�������˼·�����⣬�����ǿռ����ŵĽ��˼·����Ϊÿ�εع�Ҫ������������
 * 
 * @author Administrator
 */
public class MergeSort {
	
	public static void mergeSort(int[] array){
		//ִ�г�ʼ����MERGE-SORT(A, 1, A.length), Java�����±��0��ʼ��������λ�� -1
		mergeSort(array, 0, array.length - 1);
	}
	
	private static void mergeSort(int[] array, int p, int r){
		if(p < r){
			//�����м�λ��
			int q = (p + r) / 2;
			//�ݹ�ֽ����ֱ��Ϊһ��Ԫ��
			mergeSort(array, p, q);
			//�ݹ�ֽ����ֱ��Ϊһ��Ԫ��
			mergeSort(array, q + 1, r);
			//�ݹ�ϲ�
			merge(array, p, q, r);
		}
	}
	
	private static void merge(int[] array, int p, int q, int r){
		//����L�������鳤��
		int n1 = q - p + 1;
		//����R�������鳤��
		int n2 = r - q;
		//ʵ����������ʹ�䳤��+1���Ա�����ڱ�Ԫ��
		int[] leftArray = new int[n1 + 1];
		//ʵ����������ʹ�䳤��+1���Ա�����ڱ�Ԫ��
		int[] rightArray = new int[n2 + 1];
		int i = p;
		int k = 0;
		//��A[p.. q]���Ƶ�������
		while(i <= q){
			leftArray[k++] = array[i++];
		}
		int j = q + 1;
		k = 0;
		//��A[q + 1.. r]���Ƶ�������
		while(j <= r){
			rightArray[k++] = array[j++];
		}
		//�����ڱ�Ԫ��
		leftArray[leftArray.length - 1] = Integer.MAX_VALUE;
		rightArray[rightArray.length - 1] = Integer.MAX_VALUE;
		i = 0;
		j = 0;
		k = p;
		//�������������αȽ���СԪ�ط�������Ѽ����ƻ�ԭ����
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
