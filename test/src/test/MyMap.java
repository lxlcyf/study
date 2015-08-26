/**  
 * @Title: MyMap.java 
 * @Package test 
 * @Description: TODO
 * @author lixiaoliang 
 * @date 2015-7-6 下午2:07:35  
 * @Copyright 当当信息技术有限公司 
 * @version V1.0 
 */
package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @ClassName: MyMap
 * @Description: TODO
 * @author lixiaoliang
 * @date 2015-7-6 下午2:07:35
 * @version V1.0
 */
public class MyMap {
	public <K, V> HashMap<K, V> newHashMap() {
		return new HashMap<K, V>();
	}

	public static void main(String[] args) {
		// Map<String,String> map = MyMap.newHashMap();
		Map<String, String> map = new MyMap().newHashMap();
		map.put("a", "a1");
		map.put("b", "b1");
		map.put("c", "c1");

		Set<Entry<String, String>> set = map.entrySet();

		Iterator<Entry<String, String>> i = set.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
