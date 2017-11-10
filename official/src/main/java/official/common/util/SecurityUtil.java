package official.common.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5、SHA1加密
 * 
 *
 */
public class SecurityUtil {

	/**
	 * 对字符串进行MD5加密
	 * 
	 * @param arg
	 * @return
	 */
	public static String getMD5String(String arg) {
		return DigestUtils.md5Hex(arg);
	}

	/**
	 * 对字符串进行SHA1加密
	 * 
	 * @param arg
	 * @return
	 */
	public static String getSHA1String(String arg) {
		return DigestUtils.sha1Hex(arg);
	}

}
