/**  
 * @Title: MyQueue.java 
 * @Package test 
 * @Description: TODO
 * @author lixiaoliang 
 * @date 2015-7-14 下午2:10:45  
 * @Copyright 当当信息技术有限公司 
 * @version V1.0 
 */
package test;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @ClassName: MyQueue
 * @Description: TODO
 * @author lixiaoliang
 * @date 2015-7-14 下午2:10:45
 * @version V1.0
 */
public class MyQueue {
	public void arrayBlockingQueueTest() throws InterruptedException {
		ArrayBlockingQueue<String> arrayq = new ArrayBlockingQueue<String>(10);
		arrayq.put("1");
		arrayq.take();
	}
}
