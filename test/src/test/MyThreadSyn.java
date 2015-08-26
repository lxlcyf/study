/**  
 * @Title: MyThreadSyn.java 
 * @Package test 
 * @Description: TODO
 * @author lixiaoliang 
 * @date 2015-8-7 下午3:46:45  
 * @Copyright 当当信息技术有限公司 
 * @version V1.0 
 */
package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: MyThreadSyn
 * @Description: TODO
 * @author lixiaoliang
 * @date 2015-8-7 下午3:46:45
 * @version V1.0
 */
public class MyThreadSyn {
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	private static Object lock3 = new Object();
	static ExecutorService executor = Executors.newCachedThreadPool();

	public static void run() throws InterruptedException {
		executor.submit(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					synchronized (lock3) {
						synchronized (lock1) {
							System.out.print("1");
							lock1.notify();
						}
						lock3.notify();
						if (i < 9) {
							try {
								lock3.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}

		});
		// Thread.sleep(1);
		executor.submit(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					synchronized (lock1) {
						synchronized (lock2) {
							System.out.print("2");
							lock2.notify();
						}
						lock1.notify();
						if (i < 9) {
							try {
								lock1.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}

		});
		// Thread.sleep(1);
		executor.submit(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					synchronized (lock2) {
						synchronized (lock3) {
							System.out.print("3");
							lock3.notify();
						}
						lock2.notify();
						if (i < 9) {
							try {
								lock2.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}

		});
	}

	public static void main(String[] args) throws InterruptedException {
		MyThreadSyn.run();
	}
}
