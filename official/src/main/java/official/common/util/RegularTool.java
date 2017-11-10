package official.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTool {

	/**
	 * 只能是字母，数字，下划线组合
	 * 
	 * @param str
	 * @return
	 */
	public static boolean matchUserName(String str) {
		Matcher matcher = Pattern.compile("^[0-9a-zA-Z_]+$").matcher(str);
		return matcher.find();
	}

	/**
	 * 只能是数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean matchDigit(String str) {
		Matcher matcher = Pattern.compile("^[0-9a-zA-Z_]+$").matcher(str);
		return matcher.find();
	}

}
