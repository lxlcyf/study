package test;

/**
 * @ClassName: MyThreads 
 * @Description: 用于测试volitile是非线程安全的。  
 * @author lixiaoliang 
 * @date 2015-7-13 上午11:07:01
 * @version V1.0   
*/
public class MyThreads implements Runnable {

	public volatile Integer count = new Integer(0);

	public void inc() {

		// 这里延迟1毫秒，使得结果明显

		try {

			Thread.sleep(1);

		} catch (InterruptedException e) {

		}
		System.out.println(Thread.currentThread() + ":" + count);
		// count++;

		count++;

	}

	public static void main(String[] args) {

		// 同时启动1000个线程，去进行i++计算，看看实际结果

		final MyThreads t = new MyThreads();

		t.start();

		try {

			Thread.sleep(1000);

		} catch (InterruptedException e) {

		}

		// 这里每次运行的值都有可能不同,可能为1000

		System.out.println("运行结果:Counter.count=" + t.count);

	}

	/**
	 * @Method:start
	 * @Description:TODO
	 */
	private void start() {
		for (int i = 0; i < 1000; i++) {

			new Thread(this).start();

		}

	}

	/**
	 * @Method: run
	 * @Description: TODO
	 * @see java.lang.Runnable#run()
	 */

	@Override
	public void run() {
		this.inc();
	}

}