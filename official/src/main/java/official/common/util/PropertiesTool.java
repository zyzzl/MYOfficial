package official.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import org.springframework.core.io.ClassPathResource;

public class PropertiesTool {
	public static Properties pro = null;

	static {
		pro = new Properties();
		InputStreamReader inr = null;
		try {
			InputStream in = new ClassPathResource("message.properties").getInputStream();
			inr = new InputStreamReader(in, "utf-8");
		} catch (IOException e1) {
			LogTool.error("PropertiesTool.getValue.ClassPathResource:文件路径错误");
			e1.printStackTrace();
		}
		try {
			pro.load(inr);
		} catch (IOException e) {
			e.printStackTrace();
			LogTool.error("PropertiesTool.getValue.pro.load(InputStream):加载message.properties文件异常");
		}
	}

	public static String getValue(String key) {
		return pro.getProperty(key);
	}

}
