/**  
 * @Title: MyGenericType.java 
 * @Package test 
 * @Description: TODO
 * @author lixiaoliang 
 * @date 2015-8-6 下午7:23:24  
 * @Copyright 当当信息技术有限公司 
 * @version V1.0 
 */
package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: MyGenericType
 * @Description: TODO
 * @author lixiaoliang
 * @date 2015-8-6 下午7:23:24
 * @version V1.0
 */
public class MyGenericType<T> {

	public void doExecute(List<? extends T> object) {
		System.out.println(object.toString());
	}

	public static void main(String[] args) {
		MyGenericType<Integer> i = new MyGenericType<Integer>();
		i.doExecute(Arrays.asList(1, 2));
		MyGenericType<String> s = new MyGenericType<String>();
		s.doExecute(Arrays.asList("1s", "2s"));

	}

}
