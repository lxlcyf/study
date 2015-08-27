/**  
 * @Title: MyTest.java 
 * @Package test 
 * @Description: TODO
 * @author lixiaoliang 
 * @date 2014-11-19 下午7:11:51  
 * @Copyright 当当信息技术有限公司 
 * @version V1.0 
 */
package test;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: MyTest
 * @Description: TODO
 * @author lixiaoliang
 * @date 2014-11-19 下午7:11:51
 * @version V1.0
 */
public class MyTest {
	static class VarArgsTest {
		public static void m1(Object... ss) {
			// for (int i = 0; i < ss.length; i++) {
			// System.out.println(ss[i]);
			// }
			String s = "asdf%sadsfd%s";
			s = String.format(s, "t", 11);
			System.out.println(s);
			System.out.println(s);
		}

	}

	/**
	 * @Method:main
	 * @Description:TODO
	 * @param args
	 */
	public static void main(String[] args) {
		String[] s = new String[4];
		int i = 0;
		s[3] = "t";
		while (i < s.length && s[i++] == null) {
			System.out.println(i);
		}

		// String str = "mingri"; //定义字符串对象
		// int lastIndex = str.lastIndexOf(105,4);//查询字符i在指定范围内最后一次出现的索引位置
		// System.out.println("i所在的索引位置为："+lastIndex); //输出检索后结果
		/*
		 * MyTest.VarArgsTest.m1(""); MyTest.VarArgsTest.m1("aaa");
		 * MyTest.VarArgsTest.m1("aaa", "bbb");
		 */
		// MyTest.VarArgsTest.m1("aaa",null);

		/*
		 * System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS")
		 * .format(new Date()));
		 */

		// System.out.println(toBoolean(new Integer(1)));

		/*
		 * String s = "你好！"; try { s = new String(s.getBytes("gbk"),"gbk");
		 * System.out.println(s); } catch (UnsupportedEncodingException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */

		/*
		 * String s = "01234 "; s = s.trim(); Pattern p =
		 * Pattern.compile("^[0-9]*$"); Matcher matcher = p.matcher(s); if
		 * (matcher.find()){
		 * System.out.println(matcher.start()+"-"+matcher.end());
		 * System.out.println(Integer.valueOf("01234")); }
		 */

		/*
		 * String str = "";
		 * 
		 * String[] s = str.split(","); int length = s.length;
		 * System.out.println(length); System.out.println(s[0]);
		 */

		/*
		 * Map<String,Object> record = new HashMap<String,Object>();
		 * record.put("shop_id", 0); record.put("town_id", 10);
		 * record.put("source_id", 1); record.put("is_avaliable", 0);
		 * record.put("id", 3);
		 * 
		 * Map<String,Object> record2 = new HashMap<String,Object>();
		 * record2.put("shop_id", 0); record2.put("town_id", 10);
		 * record2.put("source_id", 3); record2.put("is_avaliable", 1);
		 * record2.put("limit_type_id", 1);
		 * 
		 * List<Map> list = new ArrayList(); list.add(record);
		 * list.add(record2);
		 * 
		 * updateList(list,record2);
		 * 
		 * for(Map m : list){ System.out.println(m.get("id")); }
		 */}

	public static void deleteNoneedColunm(Map<String, Object> record) {
		Set<Entry<String, Object>> set = record.entrySet();
		Iterator<Entry<String, Object>> i = set.iterator();
		String key;
		while (i.hasNext()) {
			key = i.next().getKey();
			if ("shop_id,town_id,limit_type_id,is_avaliable,source_id".indexOf(key) == -1) {
				System.out.println("4444444444");
				i.remove();
			}
		}
		System.out.println(record.containsKey("t1"));
	}

	public static void updateList(List<Map> list, Map record) {
		// 通过比较的主键字段找到要更新的map对象
		for (Map<String, Object> map : list) {
			if (map.get("id").equals(record.get("source_id"))) {
				System.out.println("55555");
				list.remove(map);
				// 将record中的source字段值更新至target字段，redis中存储的应该是前台表的id值。
				record.put("id", record.get("source_id"));
				// 抹去record中不需要存入redis的字段
				deleteNoneedColunm(record);
				list.add(record);
				return;
			}
		}
		// 将record中的source字段值更新至target字段，redis中存储的应该是前台表的id值。
		record.put("id", record.get("source_id"));
		// 抹去record中不需要存入redis的字段
		deleteNoneedColunm(record);
		list.add(record);
	}

	/**
	 * @Method:toBoolean
	 * @Description:转换为布尔类型
	 * @param o
	 *            原始数据
	 * @return boolean 转换类型
	 */
	private static boolean toBoolean(Object o) {
		if (o == null) {
			return false;
		}
		String s = o.toString();
		System.out.println(s);
		if (s.equals("") || s.equals("0") || s.equalsIgnoreCase("false")) {
			return false;
		}
		return true;
	}

}
