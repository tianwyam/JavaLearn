package com.tianya.java.sync;

import java.util.concurrent.Semaphore;

/**
 * @description
 *	同步工具类：Semaphore 信号量
 * @author TianwYam
 * @date 2021年6月30日下午5:17:14
 */
public class SemaphoreDemo {

	/*
	 * 同步工具类：Semaphore 信号量
	 * 定义总的信号量，拿到了，才能执行，执行完后，归还信号量，没有拿到需要等待
	 * semaphore.tryAcquire() 尝试获取 信号量
	 * semaphore.release() 释放信号量
	 * 可用于流量控制、削峰
	 */
	
	public static void main(String[] args) {
		
		Semaphore semaphore = new Semaphore(2);
		
		for (int i = 1; i < 4; i++) {
			new EatFoodThread("学生" + i, semaphore).start();
		}
		
		
	}
	
	
	/**
	 * @description
	 *	模拟一个吃饭线程
	 * @author TianwYam
	 * @date 2021年7月1日上午9:19:31
	 */
	public static class EatFoodThread extends Thread {
		
		private String name ;
		
		private Semaphore semaphore ;
		
		private EatFoodThread(String name, Semaphore semaphore) {
			this.name = name ;
			this.semaphore = semaphore ;
		}
		
		
		@Override
		public void run() {
			
			while (true) {
				
				// 尝试 抢 饭卡
				if (semaphore.tryAcquire()) {
					System.out.println(name + "：抢 到饭卡了");
					System.out.println(name + "：吃饭 ");
					
					try {
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println(name + "：吃完饭了，归还饭卡 ");
					semaphore.release();
					break ;
				} else {
					System.out.println(name + "：没有抢到饭卡，需要等待 或者 下次再来 ");
				}
			}
			
		}
	}
	
	
	
	
	
}
