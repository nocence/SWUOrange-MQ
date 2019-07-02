package com.swuorange.util;

/*
 * 
* @Description: String的工具类
*
* @version: v1.0.0
* @author: Randy
* @date: 2019年2月27日 下午9:42:26
 */
public class StringUtil {

	/*
	 * 
	 * @Description: 该方法用于将字符串的第一个字母转换成小写
	 *
	 * @return 第一个为小写的String
	 * 
	 * @return：返回值描述
	 * 
	 * @version: v1.0.0
	 * 
	 * @author: Randy
	 * 
	 * @date: 2019年2月27日 下午9:42:48
	 */

	public static String parseFirstStr(String Str) {
		if (Character.isLowerCase(Str.charAt(0)))
			return Str + "Service";
		else
			return (new StringBuilder()).append(Character.toLowerCase(Str.charAt(0))).append(Str.substring(1))
					.append("Service").toString();

	}

	public static int[] convertIntArr(String str) {
		String[] s = str.split("-");
		int[] arr = new int[s.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		return arr;
	}

}
