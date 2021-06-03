package com.tianya.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description
 *	求数组的子集合，子数组
 *	方式一：递归方式
 * @author TianwYam
 * @date 2021年6月1日下午2:37:21
 */
public class SubArray {
	
	public static void main(String[] args) {
		
		// 测试数组
		int[] list = {1,2,3,4,5,6} ;
		
		// 保存结果集
		List<List<Integer>> resultList = new ArrayList<>();
		List<Integer> subList = new ArrayList<>();
		
		// 递归调用
		subList(list, 0, resultList, subList);
		
		// 求数组的子集
		System.out.println("数组的所有子集合：");
		for (List<Integer> sub : resultList) {
			System.out.println(Arrays.toString(sub.toArray()));
		}
		
		// 求各个子集中 和 为6的集合
		System.out.println("输出和为：6");
		for (List<Integer> sub : resultList) {
			int sum = sub.stream().reduce(0, Integer::sum);
			if (sum == 6) {
				System.out.println(Arrays.toString(sub.toArray()));
			}
		}
	}
	
	
	/**
	 * @description
	 *	递归 
	 * @author TianwYam
	 * @date 2021年6月1日下午3:22:41
	 * @param list
	 * @param index
	 * @param resultList
	 * @param subList
	 */
	public static void subList(int[] list , int index, 
			List<List<Integer>> resultList, List<Integer> subList) {
		
		resultList.add(new ArrayList<>(subList));
		
		int size = list.length ;
		for (int i = index; i < size; ) {
			subList.add(list[i]);
			subList(list, ++i, resultList, subList);
			subList.remove(subList.size() - 1);
		}
		
	}
	

}















