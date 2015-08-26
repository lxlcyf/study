/**  
 * @Title: MyAbstract.java 
 * @Package test 
 * @Description: TODO
 * @author lixiaoliang 
 * @date 2015-7-6 下午7:37:21  
 * @Copyright 当当信息技术有限公司 
 * @version V1.0 
 */
package test;

/**
 * @ClassName: MyAbstract
 * @Description: TODO
 * @author lixiaoliang
 * @date 2015-7-6 下午7:37:21
 * @version V1.0
 */
public class MyAbstract<T> {
	public <T> MyAbstract() {
	};

	public static <S> void testStatic(S s) {
		System.out.println(s);
	}

	public void testDymatic(T t) {
		System.out.println(t);
	}

	public <D> void testDymatic2(D d) {
		System.out.println(d);
	}
	
	public static void main(String[] args){
		MyAbstract<String> ma = new MyAbstract<String>();
		ma.testDymatic("string");
		ma.testDymatic2(1);
		ma.testDymatic2("string");
		MyAbstract.testStatic(1);
		MyAbstract.testStatic("string");
	}
	
	public void invoker(Class<T> clazz) throws ClassNotFoundException{
		Class<?> t = clazz.forName("test.MyAbstract");
	}
}
