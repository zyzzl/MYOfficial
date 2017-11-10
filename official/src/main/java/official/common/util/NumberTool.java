package official.common.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberTool {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 根据指定长度生成纯数字的随机数
     *
     * @param length
     */
    public static String createNum(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * 空值判断
     *
     * @param str
     * @return
     */
    public static String transData(Object str) {
        if (str instanceof Date) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            str = sdf.format(str);
        } else if (str instanceof Integer) {
            str = String.valueOf(str);
        } else if (str instanceof BigDecimal) {
            str = String.valueOf(str);
        }
        return str != null ? (String) str : "";
    }

    /**
     * 判断是否包含数字
     *
     * @param content
     * @return
     */
    public static boolean hasDigit(String content) {

        boolean flag = false;

        Pattern p = Pattern.compile(".*\\d+.*");

        Matcher m = p.matcher(content);

        if (m.matches())

            flag = true;

        return flag;

    }
    /**
     * @param str 时间字符串
     * @return
     */
    public static String updateDate(String str) {
        if (str.length() != 8 && str.length() == 6) {
            return str.substring(0, 4) + "0" + str.substring(4, 5) + "0" + str.substring(5, 6);
        } else if (str.length() != 8 && str.length() == 7) {
            if (str.substring(4, 5).equals("0")) {
                return str.substring(0, 6) + "0" + str.substring(6, 7);
            } else if (str.substring(5, 6).equals("0")) {
                return str.substring(0, 4) + "0" + str.substring(4, 7);
            }
        }
        return str;
    }
}
