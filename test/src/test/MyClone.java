/**  
 * @Title: MyClone.java 
 * @Package test 
 * @Description: TODO
 * @author lixiaoliang 
 * @date 2015-6-24 上午11:41:09  
 * @Copyright 当当信息技术有限公司 
 * @version V1.0 
 */
package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @ClassName: MyClone
 * @Description: TODO
 * @author lixiaoliang
 * @date 2015-6-24 上午11:41:09
 * @version V1.0
 */
public class MyClone implements Cloneable, IMyClone,Serializable {
	Integer id;
	String name;
	Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static void main(String[] args) throws InterruptedException, CloneNotSupportedException, ClassNotFoundException, IOException {
//		 MyClone myClone = new MyClone();
//		 myClone.setDate(new Date());
//		 myClone.setId(1);
//		 myClone.setName("test");
////		 MyClone myClone2 = (MyClone) myClone.clone();
//		 MyClone myClone2 =  myClone.clone2();
//
//		 myClone2.setId(2);
//		 myClone2.setName("test2");
//		 myClone2.getDate().setDate(2000);
//		 Thread.sleep(1);

		IMyClone myClone = new MyClone();
		try {
			myClone.testAop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object clone() {
		MyClone myClone = null;
		try {
			myClone = (MyClone) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		myClone.setDate((Date) myClone.getDate().clone());
		return myClone;
	}

	@SuppressWarnings("unchecked")
	public <T> T clone2() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(this);
		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
		ObjectInputStream oi = new ObjectInputStream(bi);
		return (T) oi.readObject();
	}

	@Override
	public void testAop() throws Exception {
		String interfaceName = "test.IMyClone";
		final MyClone target = new MyClone();
		Object proxyObj = Proxy.newProxyInstance(this.getClass().getClassLoader(),
				new Class[] { Class.forName(interfaceName) }, new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("method:" + method.getName());
						System.out.println("Method before...");
						Object result = method.invoke(target, args);
						System.out.println("Method after...");
						return result;
					}
				});

		((IMyClone) proxyObj).run();
	}

	/**
	 * @Method: run
	 * @Description: TODO
	 * @see test.IMyClone#run()
	 */

	@Override
	public void run() {
		System.out.println("run");

	}

}
