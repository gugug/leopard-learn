package com.duowan.beans.util;

/**
 * 参数合法性验证.
 * 
 * @author 阿海
 * 
 */
public class ValidUtil {
	/**
	 * 是否合法的群ID.
	 * 
	 * @param groupId
	 *            群ID.
	 * @return
	 */
	public static boolean isValidGroupId(int groupId) {
		return (groupId > 0);
	}
}
