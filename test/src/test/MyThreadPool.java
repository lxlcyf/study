/**  
 * @Title: MyThreadPool.java 
 * @Package test 
 * @Description: TODO
 * @author lixiaoliang 
 * @date 2015-7-13 上午11:07:53  
 * @Copyright 当当信息技术有限公司 
 * @version V1.0 
 */
package test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName: MyThreadPool
 * @Description: 用于实现线程池
 * @author lixiaoliang
 * @date 2015-7-13 上午11:07:53
 * @version V1.0
 */
public class MyThreadPool {

	private static ArrayBlockingQueue<MyThread> threadPool = new ArrayBlockingQueue<MyThread>(10);

	public static void start() throws InterruptedException {
		int size = threadPool.remainingCapacity();
		for (int i = 0; i < size; i++) {
			MyThread myThread = new MyThreadPool.MyThread();
			threadPool.put(myThread);
			myThread.start();
		}
	}

	public static void runJob(Runnable job) {

		MyThread thread = getThread();

		thread.add(job);
	}

	/**
	 * @Method:getThread
	 * @Description:TODO
	 * @return
	 */
	private static MyThread getThread() {
		MyThread thread = null;
		try {
			thread = threadPool.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return thread;
	}

	static class MyThread extends Thread {

		private Runnable job;

		public synchronized void add(Runnable job) {
			this.job = job;
			this.notify();
		}

		public synchronized void remove() {
			this.job = null;
			try {
				threadPool.put(this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is start...");
			while (true) {
				synchronized (this) {
					if (job != null) {
						job.run();
						this.remove();
					}
					try {
						System.out.println(Thread.currentThread().getName() + " is wait...");
						wait();
						System.out.println(Thread.currentThread().getName() + " is restart...");

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	static class MyJob implements Runnable {

		/**
		 * @Method: run
		 * @Description: TODO
		 * @see java.lang.Runnable#run()
		 */

		@Override
		public void run() {
			System.out.println("myjob is running!" + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("myjob is finish!" + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyThreadPool.start();
		MyThreadPool.MyJob job = new MyThreadPool.MyJob();
		MyThreadPool.MyJob job2 = new MyThreadPool.MyJob();
		MyThreadPool.MyJob job3 = new MyThreadPool.MyJob();
		for (int i = 0; i < 10; i++) {
			MyThreadPool.runJob(job);
			MyThreadPool.runJob(job2);
			MyThreadPool.runJob(job3);
		}
		// MyThread thread = new MyThreadPool.MyThread();
		// thread.start();
		Thread.sleep(100000000);
	}
}
