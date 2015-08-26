/**  
 * @Title: MyLru.java 
 * @Package test 
 * @Description: TODO
 * @author lixiaoliang 
 * @date 2015-8-7 下午3:11:00  
 * @Copyright 当当信息技术有限公司 
 * @version V1.0 
 */
package test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: MyLru
 * @Description: TODO
 * @author lixiaoliang
 * @date 2015-8-7 下午3:11:00
 * @version V1.0
 */
public class MyLru<K, V> extends LinkedHashMap<K, V> {
	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 3688590683565264832L;
	private int maxCapacity;

	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > maxCapacity;

	}
}
