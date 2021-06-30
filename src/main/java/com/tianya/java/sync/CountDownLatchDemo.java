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
		
		new SignInThread("学生1", latch).start();
		new SignInThread("学生2", latch).start();
		
		
		try {
			System.out.println("老师等学生签到");
			latch.await();
			System.out.println("所有的学生都签完到了，老师也走了");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * @description
	 *	模拟 学生 签到 线程
	 * @author TianwYam
	 * @date 2021年6月30日下午5:30:59
	 */
	public static class SignInThread extends Thread {
		
		private String name;
		private CountDownLatch latch ;
		
		private SignInThread(String name, CountDownLatch latch) {
			super(name);
			this.name = name ;
			this.latch = latch ;
		}
		
		@Override
		public void run() {
			
			System.out.println(name + ": 签完到了");
			latch.countDown();
			System.out.println(name + ": 走了");
			
		}
	}
	
	

}
