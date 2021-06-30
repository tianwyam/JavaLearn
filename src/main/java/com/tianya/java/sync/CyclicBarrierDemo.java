package com.tianya.java.sync;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description
 *	同步工具类 CyclicBarrier
 * @author TianwYam
 * @date 2021年6月30日下午5:01:28
 */
public class CyclicBarrierDemo {
	
	/*
	 * 同步工具类：CyclicBarrier 屏障
	 * 如同有一个屏障 把所有线程都 隔开到一边，只有所有的线程 等待就绪后，屏障才打开
	 * barrier.await() 就是等待就绪，需要等所有的执行了  await 后，才能继续往下走
	 * 子线程 需要互相等待，才会继续往下执行
	 */
	
	public static void main(String[] args) {
		
		// 屏障 模拟 3个玩家玩游戏
		CyclicBarrier barrier = new CyclicBarrier(3);
		
		System.out.println("等所有玩家都准备好了，才能开始游戏：");
		
		new Thread(()->{
			
			System.out.println("玩家1 准备完毕");
			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println("玩家1进入游戏");
			
		}).start();
		
		new Thread(()->{
			
			System.out.println("玩家2 准备完毕");
			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println("玩家2进入游戏");
			
		}).start();
		
		new Thread(()->{
			
			System.out.println("玩家3 准备完毕");
			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println("玩家3进入游戏");
			
		}).start();
		
		
		
	}

}
