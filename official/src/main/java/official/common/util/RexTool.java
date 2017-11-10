package official.common.util;

import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RexTool {

    // 用户名/密码验证
    public static boolean rexParam(String str) {
        if (StringUtils.isEmpty(str) || !RegularTool.matchUserName(str)) {
            return false;
        }
        return true;
    }

    // 手机号验证
    public static boolean rexPhone(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return false;
        }
        if (phone.length() != 11) {
            return false;
        }
        if (!phone.startsWith("1")) {
            return false;
        }

        String rexStr = "^1[34578]\\d{9}$";
        if (!Pattern.matches(rexStr, phone)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String phone = "12345678911";
        String rexStr = "^1[34578]\\d{9}$";
        System.out.println("===" + Pattern.matches(rexStr, phone));
        phone = "18726343305";
        System.out.println("===" + Pattern.matches(rexStr, phone));
    }

    /**
	 * 电话号码正则表达式：移动+固话（3或4位区号固话、400固话）
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles){   
		Pattern p1 = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
		Pattern p2 = Pattern.compile("^\\d{3}-\\d{7,8}|\\d{4}-\\d{7,8}|\\d{4}-\\d{3}-\\d{4}|\\d{4}-\\d{7}$");
		Pattern p3 = Pattern.compile("^\\d{3}\\d{7,8}|\\d{4}\\d{7,8}|\\d{4}\\d{3}\\d{4}|\\d{4}\\d{7}$");
		Matcher m1= p1.matcher(mobiles); 
		Matcher m2 = p2.matcher(mobiles);
		Matcher m3= p3.matcher(mobiles);
		return m1.matches() || m2.matches() || m3.matches(); 
	} 
	
	public static boolean isHanZi(String arg){
		Pattern p = Pattern.compile("^[\u4e00-\u9fa5\\(\\)\\（\\）]{1,4}$");  
		Matcher m = p.matcher(arg.trim());  
		return m.matches(); 
	}
}
