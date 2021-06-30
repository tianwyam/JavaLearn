package com.tianya.java.sync;

import java.util.concurrent.CountDownLatch;

/**
 * @description
 *	同步工具类 CountDownLatch
 * @author TianwYam
 * @date 2021年6月30日下午4:51:12
 */
public class CountDownLatchDemo {
	
	/*
	 * 
	 * 同步工具类：CountDownLatch 计数器
	 * 内部有个计数器，只有等计数器为0时， latch.await() 才能继续往下走
	 * latch.countDown() 就是每一次 计数 减一 
	 * 子线程不需要等待，会继续往下执行
	 */
	
	
	public static void main(String[] args) {
		
		// 计数器
		CountDownLatch latch = new CountDownLatch(2);
		
		new Thread(()->{
			
			System.out.println("学生1 签完到了");
			latch.countDown();
			System.out.println("签完到 学生1 走了");
			
		}).start();
		
		new Thread(()->{
			
			System.out.println("学生2 签完到了");
			latch.countDown();
			System.out.println("签完到 学生2 走了");
			
		}).start();
		
		
		try {
			System.out.println("老师等学生签到");
			latch.await();
			System.out.println("所有的学生都签完到了，老师也走了");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
