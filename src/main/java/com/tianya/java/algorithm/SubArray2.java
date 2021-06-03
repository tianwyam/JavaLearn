package com.tianya.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description
 *	求数组的子集合，子数组
 *	方式二：全排列方式
 * @author TianwYam
 * @date 2021年6月1日下午2:37:21
 */
public class SubArray2 {
	
	public static void main(String[] args) {
		
		// 数组
		int[] list = {1,2,3,4,5,6} ;
		
		// 保存结果集 
		List<List<Integer>> resultList = new ArrayList<>();
		
		// 全排列 循环
		int size = list.length ;
		for (int i = 0; i < size; i++) {
			
			// 保存单个
			resultList.add(new ArrayList<>(Arrays.asList(list[i])));
			
			for (int j = i+1; j < size; j++) {
				
				List<Integer> subList = new ArrayList<>();
				subList.add(list[i]);
				
				for (int k = j; k < size; k++) {
					subList.add(list[k]);
					
					// 保存重新一个数组
					resultList.add(new ArrayList<>(subList));
				}
			}
			
		}
		
		
		
		System.out.println("数组的所有子集合：");
		for (List<Integer> sub : resultList) {
			System.out.println(Arrays.toString(sub.toArray()));
		}
		
		
		System.out.println("输出和为：6");
		for (List<Integer> sub : resultList) {
			int sum = sub.stream().reduce(0, Integer::sum);
			if (sum == 6) {
				System.out.println(Arrays.toString(sub.toArray()));
			}
		}
	}
	
	

}















